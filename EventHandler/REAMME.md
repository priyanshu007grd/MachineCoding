HLD AND LLD : https://www.linkedin.com/pulse/system-design-distributed-job-scheduler-keep-simple-stupid-ismail/

public class EventTo<T> {
    private String id; // sequencial primary key
    private Integer retryCount;
    private String name;   // event name
    private String state;  // QUEUED,PROCESSED,FAILED
    private EventType type;
    private Map<String,String> metadata;  // header
    private T payload;
    private FacilityLookupKey facilityLookupKey;
    private EventStatus status;
    private String createdBy;
    private Date createTs;
    private String updatedBy;
    private Date updateTs;
}

public enum EventType {
HTTP, HTTPS, JMS, KAFKA, INTERNAL
}
public class FacilityLookupKey {
    private String facilityCountryCode;
    private Integer facilityNum;
    private String correlationKey;
}
public enum EventStatus {
PROCESSED, QUEUED, REJECTED, FAILED
}
    

Scheduler
{
    consumeMessages()
        fetch list of facility from config
        processEachFacility(facility)

    processEachFacility(facility)
        get all the event.
        sort all the event by as requirement
        schedulerService.retryQueuedEvent(event);
}


GdcSchedulerService
{
    retryQueuedEvent(EventTo<String> event)
        String eventName = event.getName();
        switch (eventName){
            case WITRON_FULFILLMENT_PLAN: witronInitialFulfillmentPlanEventHandler.processEvent(getEventWithType(event,WitronIntialFulfillmentPlan.class));
        }


    public <T> EventTo<T> getEventWithType(EventTo<String> event, Class<T> type){
        EventTo.Builder<T> builder = EventTo.Builder.start();
        builder.name(event.getName());
        builder.id(event.getId());
        builder.type(event.getType());
        builder.payload(GlsCommonUtil.deserializeToObject(event.getPayload(), type));
        builder.metadata(event.getMetadata());
        builder.status(event.getStatus());
        builder.state(event.getState());
        builder.retryCount(event.getRetryCount());
        builder.facilityLookupKey(event.getFacilityLookupKey());
        return builder.build();
    }
}







Event flow
Step 1
WitronFulfillmentConfirmationEventListener.processEvents()

Step 2
EventTo<FulfillmentDto> fulfillmentConfirmation = mapToEventTo(message, WitronHeadersUtil.getHeaderContextAsMap());
witronFulfillmentConfirmationService.handleEvent(fulfillmentConfirmation);

Step 3
handleEvent
try {
    validatePayload(event.getPayload());
    if (existingEvent.isPresent()) {
        LOG.info("{} event with id {} is a duplicate event", event.getName(), event.getId());
        processDuplicateEvent(event, existingEvent.get());
    } else {
        eventRepository.save(mapToEventEntity(event));
        processEvent(event);
        updateEventStatus(event, EventStatus.PROCESSED);
    }
}
catch (Exception e) {
LOG.error("Failed to process" + event.getName() + " event with id " + event.getId(), e);
updateEventStatus(event, EventStatus.FAILED);
}

Step 4
processEvent // each handler has its one logic






Schedular flow

Step 1
GdcScheduler.consumeGdcMessages() -> processEachFacility() -> getAndProcessPendingEvents() -> sort all the event as per requirement -> schedulerService.retryQueuedEvent(event);

Step 2
GdcSchedulerService.retryQueuedEvent(EventTo<String> event)
{
    String eventName = event.getName();
    switch (eventName){
        case WITRON_FULFILLMENT_PLAN:witronInitialFulfillmentPlanEventHandler.processEvent(getEventWithType(event,WitronIntialFulfillmentPlan.class));
    }
}

Step 3
processEvent // each handler has its one logic
event.setStatus(EventStatus.PROCESSED);
witronEventsService.updateEventStatus(event);  internally calling event repository



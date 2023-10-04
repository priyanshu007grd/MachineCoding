
https://gitlab.com/shrayansh8/interviewcodingpractise/-/tree/main/src/LowLevelDesign/DesignVendingMachine


State

IdleState
    IdleState
        machine.setCoinList(new ArrayList<>());
    clickOnInsertCoinButton
        machine.setVendingMachineState(new HasMoneyState());
    updateInventory
        machine.getInventory().addItem(item, codeNumber);


HasMoneyState
    insertCoin
        machine.getCoinList().add(coin);
    clickOnStartProductSelectionButton
        machine.setVendingMachineState(new SelectionState());
    refundFullMoney
        machine.setVendingMachineState(new IdleState(machine));
        remove coin from last

SelectionState
    chooseProduct
        check amount paid by user
        if insufficiant amount
            refundFullMoney()
        else 
            getChange()
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));

        getChange()
        refundFullMoney()

DispenseState
    dispenseProduct
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;


Inventory
    ItemShelf[]
        code
        Item
            ItemType
            price   
        soldOut


VendingMachine
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;


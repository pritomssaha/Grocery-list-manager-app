1.The application must contain a geceryList, so I create a geoceryList class which has a attribute listID and listName, and method addList(),which can add a newList,UpdateList(),renameList(),and saveList()

2.The application must contain a User to do all the operating, so I create a user class, which has attributes userID,listID, itemID and Userinformation,the List, the listID and itemID allow User to acess the groceryList and itemsUserWantBuy class

3.The application must contiain a list that the item user wants user want buy, so I create a class which has has the atrributes UserID, itemID and quantity, and method addItem()(allow user to add item),deleteItem(allow user to delete Items from lsit),changeQuantity(allow user change quantity) and saveList()(which will save the lsit after user makes a change),because it has the attribute itermID, the class is allow to acess the itemDatabase class

4. The application must contain a DB of items, so I create a class call itemDatebase,which contain the attribute itermID,itemType,itemName,quantity,and price, also the class contain the method,addItem(), deleteitem(), and findByname()(find item by search the name),
and can acess the class itemCategory nd itemtype.

5. The application must alllow user to find item by type , so I create a class called itemType, which has the attribute itermID, itemType and itemName,and also the method addtype() and removeType

6. The application must allow user to checkoff items, so I create a class called checkoff, it contain the attribute itemID and checkoff, method addCheckoff(),
deleteCheckoff(), deleteAllCheckoff() and saveList()

7.The User interface(UI) must be intutive and reponsive. Not considered because it does not affect he design directly.
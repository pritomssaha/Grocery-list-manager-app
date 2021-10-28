### GroceryListManager UML Explanation:

------------
### Class Name: User 
Design: This is a relation between User and Item List. Need to create a User class for the same. Relationships need to be added for Item List and User.

Attributes: UserID,User FirstName, UserLastName, UserAddress 
        Note: The attributes hold information of users in database 

Operations:
          +addItemToList () →  adds an item to the user's list
          +DeleteItemsFromList () →  This method deletes an item from the Grocery list that the user created.
          +SearchItemByName () → User search for an item in the database by the name
          +CheckOffItems () →  checks off selected items from a list
          +CheckOffAllAtOnce () →  checks off all the items in a list
          +UpdateList () → With this method user can rename, or change the type of a list
          +DeleteList () → This method allows the user to delete  a list


####Class Name: ‘Item List’

Design: To implement the requirement, a class is needed to be added which will have all the items selected by one User.

Attributes: ListName: String 
            ItemType: String 
            ItemName: String
         Note: Shows the list name, Item category, and the name of the Item 
Functions:
         +UpdateQuantityOfItem () →  method updates the quantity of an item in the grocery list
         +SaveUpdates&Changes () →  method saves all the changes made in real time
         +SaveChecksOff () →  method saves the items after checking it off


### Class Name: Database

Design: It implements the database required for the items and categories

Attributes: TypeID: int 
            ItemID: int 
            ItemPrice : Double 
            ItemQuantity: int

         Note: hold Item Type, Item Id, item price and quantity of the items 
Functions:
        +PopUpForUserToAddItemToTheList() → method helps to ask user to add an item in it's grocery list
        +SaveNewItem () → method saves new item in the grocery list 
        +SaveTypeOfItemByType () → method identifies an item by it's type
        +PopUpForUserToSearchByTypeForItemNotFoundByName () → if the item is not found then the method asks the user to search it by it's type



#### Class Name: Hierarchical Type

Design: It implements the database required for the items and categories

Attributes: ItemTypeLevel : String 
            ItemLevel : String
Functions:
           +ItemType () →  method finds all the items by it's type in level 1
           +Item () →  method finds all the items by it's name in level 2



Relationships between the classes:

            User can have multiple ItemList
            Item List can have one or multiple Item
            One User can have one or many Item List 

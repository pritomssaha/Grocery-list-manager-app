# Design Information

## Requirements

#### 1.

>  A grocery list consists of items the users want to buy at a grocery store. The application
> must allow users to **add items to a list**, **delete items from a list**, and **change the quantity**
> of items in the list (e.g., change from one to two pounds of apples).

In order to meet this requirement, a few classes must be first created. First there must be a user class since we are dealing with users. We must also have a ShoppingList class to store the items on our grocery list, and a ShopItem class to store our items. Inside the user class i add the methods newList() to create a new list. Inside the ShoppingList class i add deleteItem() to delete an item off the list, and inside the ShopItem class i add editQuantity() to edit the quantity of the item.

##### 2.

> The application must contain a database (DB) of **items** and corresponding **item types** ​.

I create an Item class and an ItemType class to satisfy these requirements.  The item class will contain the name of the item as a string and a getter to return that string. ItemType will contain a category string, a getter to return that category. We use a solid line to connect Item and itemType to show that there is an association between the two in that an item may have 1 ItemType and an ItemType may have 0 or many Item

##### 3.

> Users must be able to add items to a list by picking them from a hierarchical list, where
> the first level is the item type (e.g., cereal), and the second level is the name of the
> actual item (e.g., shredded wheat). After adding an item, users must be able to specify a
> quantity for that item.

From the ShoppingList class, I created a dependency on the ItemType class. Inside the itemType class i created getAllTypes() which allows the ability to list all of the categories. Then i created getItemsInCategory() to get all Item instances that belong to that category. Finally, the addItem() inside ShoppingList will allow you to add any number of Item inside the container class ShopItem, which holds a single instance of the item class.

##### 4.

> Users must also be able to specify an item by typing its name. In this case, the
> application must look in its DB for items with similar names and ask the users, for each
> of them, whether that is the item they intended to add. If a match cannot be found, the
> application must ask the user to select a type for the item and then save the new item,
> together with its type, in its DB.

I add a dependency from the ShoppingList class to the Item class, and a method inside the Item Class called searchAllItems() which searches all items for a name. If no item is found, allow the user to call the createNewItem() which allows them to set the name and category so that it can later be used by a ShopItem and inserted into the ShoppingList.

##### 5.

> Lists must be saved automatically and immediately after they are modified.

This is not considered as it does not affect design of the classes or methods. 

##### 6.

> Users must be able to check off items in a list (without deleting them).

Inside the ShopItem class, i added the field quantity of type int and checked of type boolean. Next i added a method checkState() to see the state of the checked field, and checkItem() to toggle the state. 

##### 7.

> Users must also be able to clear all the check-off marks in a list at once.

Inside the ShoppingList class, i add a checkAllShopItems() which will check all unchecked ShopItems in it's list at once. 

##### 8.

> Check-off marks for a list are persistent and must also be saved immediately.

Not considered as this does not effect the design. Only the implementation.

##### 9.

> The application must present the items in a list grouped by type, so as to allow users to
> shop for a specific type of products at once (i.e., without having to go back and forth
> between aisles).

The method inside ShoppingList called myItemsOfType() will return only the specified type of shopItem in it's list.

##### 10.

> The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
> farmer’s market list”). Therefore, the application must provide the users with the ability to
> create, (re)name, select, and delete lists.

Inside ShoppingList, i add the setName() method to allow renaming. I then add newList() to allow the creation of new lists, getLists() to list all of the lists and allow selection, and deleteLists() to allow deletion of multiple lists all inside of the User class since that is where they are all stored. I also use composition to show that when the user is destroyed, so will the shoppingList.

##### 11.

> The User Interface (UI) must be intuitive and responsive.

Not important to the design of the classes or methods.

# Design Information

1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
	-  To satisfy this requirement, I added to the designa class `grocery_item` with attributes `itemId` and `quantity` and a class `grocery_list` with attributes `listId` and `name`. Class `grocery_item` can operate the method `getItem(int itemId)`. Class `grocery_list` can operate methods `addItem(String item)`, `deleteItem(int itemId)`, and `changeItemQuantity(int itemId, Double quantity)` .  

2. The application must contain a database (DB) of items and corresponding item types .
	- To satisfy this requirement, I added to the design a class `item` with attributes `itemId`, `name`, and `type` and a class `type` with attributes `name` and `items`.
	
3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.
	- To satisfy this requirement, I modify the method `addItem(String item)` on class `grocery_list`  to `addItem(String type, String item)`. When an item added to a `grocery_list` the default quantity is 1, the user can modify the quantity by `changeItemQuantity(int itemId, Double quantity)`.
	
4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.
	- To satisfy this requirement, I modify the method `similarItems` with the attributes `name` and `similarItems`, and I added to the class `grocery_list`  a new method `getSimilarItem(String name)`.
	- I also added to the design a class `items_DB` with attribute `items` and a class `types_DB` with attribute `types`. Class `item` can operate methods `addItem(String)`, `getItemId(String typeName, String itemName)`, `getItemName(int itemId)`, `getItemType(int itemId)`, `deleteItem(int itemId)`, and `selectItem(int itemId)`. Class `types` can operate methods `addType(String name)`,  `addItemToType(String item, int typeId)`, `selectType(int typeId)`, and `deleteType(int typeId)`.

5. Lists must be saved automatically and immediately after they are modified.
	-	To satisfy this requirement, I added to Class `grocery_list` a new method `updateList()`.

6. Users must be able to check off items in a list (without deleting them).
	- To satisfy this requirement, I added to Class `grocery_item` an attribute `isCheckOff`.
	
7. Users must also be able to clear all the check-off marks in a list at once.
	- To satisfy this requirement, I added to Class `grocery_list` a method `clearCheckOff()`.
	
8. Check-off marks for a list are persistent and must also be saved immediately.
	-	To satisfy this requirement, I added to Class `grocery_item` a new method `updateGroceryItem()`.
	
9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).
	- To satisfy this requirement, I added to Class `grocery_list` a method `groupByType()`.
	
10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.
	- To satisfy this requirement, I added to the design a class `user` with attribute `userId`. Class `user` can operate methods `createList(String name)`, `rename(int listId, String newName)`, `selectList(String name)`, and `deleteList(String name)`.
	
11. The User Interface (UI) must be intuitive and responsive.
	-	Not considered because it does not affect the design directly.

## Additional Information about the Design 
- A user can create multiple grocery lists and they can select, rename, and delete the lists they created.
- Each grocery list can add multiple grocery items. Users can modify the quantity or delete the item they add to the grocery list.
- User need to specify the item type and name in order to add it to the list. Or they need to find all the item with the similar name and select the item, if it's not found, the user can give a type of the item and add the new item to the database. 
- Each item has a similar items list (class).
# GroceryListManager Friday Team 3

# Design 1
![](https://lh5.googleusercontent.com/2HzZmlVUgbiCMLAc35wpA2znfXPRzPSAKi0nSUn1WKi5jCS1HD-CPdQo5WgQl-ornWhSAtGi_9rUO-zhI4MF7YqUQfa1VRKMQmsa5SGuOJmdoocKS4N4mq1MbFHOFhSve0m2eSnB)

## Pros:
- NewList() is a part of the user class
- SearchItem() is in user class which allows the creation of a list using a new item
- All methods that change the list will call SaveList()
- The ability to make custom items.
## Cons:
- EditList() in **User** is unclear in what it’s going to do.
- Item and ItemTypes are one class
- No method to loop through Item Types
- No methods to filter or sort
# Design 2
![](https://lh3.googleusercontent.com/21YtkeR01CfMKgpcptN6P9jqwQf5fHxc2e_o5xj_FzI4JNp50KcKwWAt2bqLU3T4qIGGYjL1bGC4WYxsp9h-65D_akHkuoLWp7loomXlmjMLnTyd2hqQdW4-h-UdshcnmqJYa49V)

## Pros:
- Since all items of type are stored inside the type object, lookups are faster.
- The qrocery_item lets us not have to check the item itself, therefore supports multi-lists
## Cons:
- HashMap is too specific for the UML.
- There are 2 DBs when A5 called for 1 DB of both.
- addItem() assumes that there is one DB.
- addItem() should take an itemId to create a grocery_item
# Design 3
![](https://lh6.googleusercontent.com/HWRcKVCxnLNmMqg75BYoZahwIE1hiRqqrmiIi-eua246ru4GEMu6yRJRUlVUAElqmjW7hleIsfyQUKFWrmyxYNKklnSqGgbe0G_hZVvHGbUDoGSUbBxFVtXhyFcA_XdFXwDVAwlQ)

## Pros:
- items belong to itemType which is a clean relationship
## Cons:
- editItem() should have a quantity.
- No method to list item by type / Filter items
- No method to search item by name
- TypeOfList not part of original specifications 
- ArrayList too specific in ListOfItems
- item stores isChecked which means if there are multiple lists containing the same item, the checked state will be the same between them.
- No method to group listItems by type
- No select list method
# Design 4
![](https://lh4.googleusercontent.com/Klkpcm_aiMvFGhacUhbInc6CPVf2jMfOrB0URmBeMB2jQI_VQztovk8HEVj624dZcQT7k-W8CvR4br073r9Oc5H6q_cfjDG9rOZJlPYhcktTH0WQYqA2rVS9t0Ot81hbtP7_jKOF)

## Pros:
- Has a wrapper class ShopItem which helps us make multi-lists.
## Cons:
- Username & Userid are redundant 
- Missing new item creation.
- Missing searchItemByName
# Design 5

Md Foyjul Anwar

![](https://lh6.googleusercontent.com/WNiPK7jGAGs3WKXwo3Dq0kU3pHJcxzII7AtCP6ZodPnNxSAoLoXNo4XZc4GqkFS_UQfJmJCJs_YX1MNBbt42RsE18rEGdSJ03HXTxt-_hL2iNKGtpWGq23n6lfJohdhGvzATTyEO)

## Pros:
- Can delete multiple items from the list
- Method to save updates & Changes
## Cons:
- No method to create new list
- Itemlist contains itemName and ItemType instead of separating them.
- No method to group list items by type
- No way to create multiple lists
# Design 6
![](https://lh3.googleusercontent.com/aZdcfXm6KdeifKuj9HvzX52a-vyYzJcw_YEzMCkJD4xxSbAOKU4L-ETeDpBZKbxujbAmF1agAzQUOZt-ZJgI2R7lntbGCd4kKJtBNvcZzvAYrnC4aFX8-atDDgL8eF1WNFldpwzq)

## Pros:
- Has saveList() method
- Checkoff separate from database
## Cons：
- Misspelled itemType
- No method to ListTypes
- No findByType 
- No relation between groceryList and items
- itemDatabase holds quantity which means it will be the same for all lists
-  No select list
- No way to filter shopping list by type


# Team Design
![](https://paper-attachments.dropbox.com/s_B2BF808890FA59BB3DDC6EEF5014EC0F2B7B91A08EC9618B9057EA2242225755_1602885429373_image.png)


**Commonalities:**

- Similar to design 1 & 5, a database class is referenced to meet instruction #2
- Similar to design 1, 2, and 4, an item wrapper class was used to contain quantity and check-state.
- Similar to design 1 & 5, we added a delete multiple items method for the ShoppingList.
- Similar to design 1 & 5, we create a method to create item if the search does not yield any

**Differences:**

- We decided that it would be easier to use inheritance so that calling each parent part can be done at a child part.
- itemWrapper contains a save method
- SearchByName() implements functionality from item

**Design Justification (Following the requirements of Assignment 5):**

1. Inside User class created newList() to create a new ShoppingList. Inside ShoppingList, created methods addItem(), deleteItem(). Created ItemWrapper class to store quantity and created changeQuantity() to modify it.
2. Created classes `ItemType` which class `Item`  extends. 
3. Added getallTypes() to class `ItemType` which lists all the categories to choose from. Added getItemsOfType() to `Item`   class in order to display all items of a given type. The constructor of itemWrapper would handle setting quantity and checkState.
4. Created a searchByName() method inside of `ShoppingList` which is connected through a realization relation to `Item`. the searchByName() method inside ShoppingList will use the  searchByName() method in `Item` in it’s own implementation. If no items are returned, then it will call the constructor of item and then add it to the ShoppingList. 
5. A saveList() was added to `ShoppingList` and a saveListItem() was added to `ItemWrapper`
6. Added checkedState boolean to `ItemWrapper` and a changeState method.
7. Added a clearCheckMarks() method to `ShoppingList`
8. Mentioned in 5
9. Added a parameter to displayItems() inside of `ShoppingList` that will specify if the items should be grouped by category
10. Added newList(), renameList(), deleteList(), selectList() to `User`
11. Not a functional requirement


# Summary

In our group meeting, we went through each project one by one and examined it’s flaws, missing requirements, and the things it did well. We gave each person’s diagram a thorough evaluation and allowed each group member to explain their methodology. We learned that it is easy to make minor mistakes. We also learned that it is hard to display your ideas in a UML diagram since we sometimes could not make out what was intended. 
As a team, we discovered that inheritance was a clear way of designing our application. 


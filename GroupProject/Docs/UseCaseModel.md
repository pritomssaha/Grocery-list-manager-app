# Use Case Model

**Author**: Greenhorn
**Version:** V1

## 1 Use Case Diagram

Diagram: 

![](https://drive.google.com/uc?export=view&id=1hwi55qHhRPELVLwjEHatOZPl2Xtzh3t6)

## 2 Use Case Descriptions

##### Create List

  Requirements: Create a new list and add it to the memory and database.

  pre-conditions: must select the create a new list option and give a name for it. The same list must not already exist.

post-conditions: A new list must be created.

Scenarios: The user wants to create a new list and clicks on the new list button.



##### Select List

Requirements:  The user selects the current list.

Pre-conditions: The user must have at least one list that exists.

post-conditions: A list must be set as the current list.

Scenarios: The user wishes to select a grocery list. 



##### Delete List

Requirements: The user wants to delete the currently selected list

pre-conditions: A current list must be selected.

post-conditions: The list must be deleted and the current list must change.

scenarios: The user wishes to delete a list. So the user selects it and presses delete.



##### Rename List

requirements: The user wants to rename the currently selected list

pre-conditions: a current list must be selected.

post-conditions: the currently selected list must be renamed to a non-null value.

scenarios: The user wishes to rename a list. The user then selects the list and presses rename.



##### Display List

requirements: the user must want to display the current contents of a selected list

pre-conditions: a current list must be selected

post-conditions: the grocery list must be displayed on the ui.

scenarios: The user wishes to display a lists. So the user selects a list and then displays it so that they can interact with it's contents.



##### Add Item

requirements: An item will be added to the current list.

pre-conditions: An item will be selected and a quantity specified.

post-conditions: The item must be added to current list.

scenarios: The user wants to add an item to the current list, so they select an item.



##### Delete Item

requirements: An item will be removed from the current list.

pre-conditions: an item in the current list must be selected

post-conditions: the item will be removed from the current list.

scenarios: The user wants to remove an item from the list, so they select it and then delete it. 



##### Edit Quantity

requirements: The quantity of an item in the current list is changed.

pre-conditions: An item that is in the current list must be selected.

post-conditions: The item's quantity must be changed to a q > 0

scenarios: The user wants to edit the quantity of an item in their current list, so they select the item and specify a new quantity. 



##### Change Check Mark

requirements: The check state of an item in the current list is changed.

pre-conditions: An item in the current list must be selected.

post-conditions: The item's check state will be set.

scenarios: The user wishes to mark the item. 



##### Search

requirements: An item will be searched for in the database

pre-conditions: The user must select the search item option.

post-conditions:  A display of items will be listed from the search results.

scenarios: The user wishes to add an item to their current list, and so they search the database for an item.
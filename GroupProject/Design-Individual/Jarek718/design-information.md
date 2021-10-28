1: The user must be able to: make a new list, remove a list, edit a list, and Search up lists.
    Therefore, NewList(), DestoryList(), EditList(), and SearchList(). In that order. 
    DisplayList() is show the list in full. SearchItem() is lookup a item without a list attached.

2: A list should be easy to implement so i made it a arraylist of items objects.
    You need to be able to add, remove, edit item quantity, mark items, and clear marks.
    Therefore, AddItem(), RemoveItem(), EditItem(), MarkItem(), and ClearAllMark().
    RemoveAllMark() removes the items that are marked from the list, a mass delete.
    SaveList() is there so that each time a list is adjusted in any way it auto-saves.

3: Items must have a type so I added a String called ItemType (this could be remade in making it an array of types).
    Items need to have the ability to be marked so a boolean called mark.
    You need to be able to find the location so i added GetLocation().
    NewItem() and Remove() are there to make custom items.

4: The User interface(UI) must be intutive and reponsive is not relevent to design.
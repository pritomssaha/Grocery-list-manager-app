package edu.qc.seclass.glm.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model_Search_Parent implements Serializable
{
    private String category_row_name;
    private boolean expanded;
    private List<Model_Search_Child> Children= new ArrayList<>();

    public Model_Search_Parent(String category_row_name, List<Model_Search_Child> Children)
    {
        this.category_row_name = category_row_name;
        this.expanded = false;
        this.Children = Children;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void toggleExpanded() {
        this.expanded = !this.expanded;
    }

    public String getCategory_row_name() {
        return category_row_name;
    }

    public void setCategory_row_name(String category_row_name) {
        this.category_row_name = category_row_name;
    }

    public List<Model_Search_Child> getChildren() {
        return Children;
    }

    public void setChildren(List<Model_Search_Child> children) {
        Children = children;
    }
}

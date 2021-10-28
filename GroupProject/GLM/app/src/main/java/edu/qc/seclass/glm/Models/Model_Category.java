package edu.qc.seclass.glm.Models;

public class Model_Category {
    String categoryName,id,tv1,tv2,tv3;
    private boolean expanded;
    public Model_Category(String categoryName, String id) {
        this.categoryName = categoryName;
        this.id = id;
    }


    public Model_Category(String categoryName, String id, String tv1, String tv2, String tv3) {
        this.categoryName = categoryName;
        this.id = id;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
        this.expanded = false;

    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTv3() {
        return tv3;
    }

    public void setTv3(String tv3) {
        this.tv3 = tv3;
    }
}

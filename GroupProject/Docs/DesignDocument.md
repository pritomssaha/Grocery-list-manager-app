# Design Document

**Author**: Greenhorn
**Version:** V2

## 1 Design Considerations

### 1.1 Assumptions

We will use:

- Android studio to develop the app,

- J-unit for unit testing, 

- SQlite for databases/backend

- Android with Minimum target for API level at 21

### 1.2 Constraints

We will be limited by our API level we selected being 21, and our J-Unit testing will not be as advanced as selenium. 

Since we are using SQlite locally, our data will not sync between devices.

### 1.3 System Environment

We will assume any android device currently of running API level 21 or above.

## 2 Architectural Design

### 2.1 Component Diagram

![](https://drive.google.com/uc?export=view&id=1-mb1CDc3CfTWwH6Qa-CS2y3MITuLzYJO
)

### 2.2 Deployment Diagram

![](https://drive.google.com/uc?export=view&id=1YpD2b3GitOyqhkNTAkYkCF1wnmsddYeG)

## 3 Low-Level Design

### 3.1 Class Diagram

![](https://paper-attachments.dropbox.com/s_B2BF808890FA59BB3DDC6EEF5014EC0F2B7B91A08EC9618B9057EA2242225755_1602885429373_image.png)

### 3.2 Other Diagrams
#### View Model Diagram

![](https://google-developer-training.github.io/android-developer-advanced-course-practicals/images/14-1-a-room-livedata-viewmodel/dg_architecture_comonents.png)

## 4 User Interface Design

![](https://cdn.discordapp.com/attachments/766781995887755276/772381199238168576/UI_diagram.png)
# Test Plan

**Author**: Greenhorn
**Version:** V2.1
**Commit:** 0ef29eb252c586f2ca4a3f5612bb095460a78af5

## 1 Testing Strategy

### 1.1 Overall strategy

- **Unit Testing:** In unit testing, each module will be tested separately. We will test each module manually by writing test cases for each module. We will compare the results of each module with the expected result to ensure all the module run properly. Software
  engineer will perform the unit testing.
- **Integration Testing:** In intergration testing, we will test multiple module work as expected. Integration test will expose  defects in the interfaces and the interactions between integrated components. Both QA engineer and software engineer will perform the integration test.
- **System Testing:** System testing will be performed on the complete program. In the system testing process we will verify all the requirement the app can fulfill. Black box testing will be performed in system testing process. QA engineer will perform the system testing after building the complete app.
- **Regression testing:** In regression test process, we will check if modifying code has any impact on the outcome. Both QA engineer and software engineer will perform the integration test.

### 1.2 Test Selection

- In unit testing and regression testing, we will use white box testing. We will test each module seperately to check if the module give the correct output.
- Black box testing will be used in system tesing process. We will test if the app work properly, what are the requirement the app can fulfill etc.

### 1.3 Adequacy Criterion

- In the structural coverage, we will test each component and the combination of the component to verify the expected result. Unit testing and integration testing will be used to perform structural testing.
- For the functional coverage, we will verify the functionality of the software against the requirement. We will do system testing to perform the functional coverage.

### 1.4 Bug Tracking

- We will check each module. If there is error in a module, we can easily identify the error. This is the least costly of all the testing.
- We will test the interconnection between the integrated units. If all the module pass the unit test but failed in the integration test, we know there is a error while we connect them.
- During the system testing, if it fails to fulfill the requirement like crash the app or do not work properly we track the error.
- We will enlist all the bugs during the testing and notify the project manager.

### 1.5 Technology

- Junit will be primary technology for the testing. We will write JUnit test cases to compare the result of each module to the expected result.
- Along with Junit, [livedata-testing](https://github.com/jraska/livedata-testing) will also be used to simplify the testing process.

## 2 Test Cases

| Purpose                                         | Steps                                                        | Expected Result                                 | Actual result                                                | pass/fail | Additional Information |
| ----------------------------------------------- | ------------------------------------------------------------ | ----------------------------------------------- | ------------------------------------------------------------ | --------- | ---------------------- |
| Test the app open properly                      | Open the app                                                 | open the app without crashing                   | The app open without any crash                               | pass      |                        |
| Test user can create a list                     | User create a list                                           | A list should appear in the app                 | Failed to create the list                                    | fail      |                        |
| Test user can delete a list                     | User delete a list                                           | The List should be disappear in the app         | Failed to delete an existing list                            | Fail      |                        |
| Test user can rename a list                     | User rename a list                                           | The list should be renamed                      | Failed to rename selected list                               | Fail      |                        |
| Test user can select a list                     | User select a list                                           | The list should be selected                     | Passed to select a list                                      | Pass      |                        |
| Test user can add item to a selected list       | User add item in list                                        | The item should be appear in the list           | Failed to add item in an existing list                       | Fail      |                        |
| Test user can delete item to a list             | User delete item in list                                     | The item should be disappear from the list      | Failed to delete the selected item in the list               | Fail      |                        |
| Test user can change quantity of item to a list | User change quantity of item in list                         | The modified quantity should show in the list   | Failed to change quantity of a selected item                 | Fail      |                        |
| Test user can search from a existing item list  | User search item from a existing list                        | The search result should appear                 | Successfully search an item                                  | Pass      |                        |
| Test user can check off a item                  | User check off a item in list                                | The item should be check off                    | Successfully checkoff a item                                 | Pass      |                        |
| Test user can clear off marks at once           | User clear off all marks at once                             | All the checkbox should be clear off            | Successfully clear off all check marks by clicking one single button | Pass      |                        |
| Test the list is saved automatically            | create a list and close the app. Then open the app to check if the list was saved | The list should appear same  when it was closed | Failed to save item after closing the app                    | Fail      |                        |

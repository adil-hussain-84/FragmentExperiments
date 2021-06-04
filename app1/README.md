# Fragment restoration bug when Fragment is added in an Activity

This Android application demonstrates that a Fragment does not re-attach to its View on Activity recreation when the View is added to the View hierarchy at any point after the `Activity.onCreate(savedInstanceState:)` lifecycle method.

Run the `recreate_activity()` test method in the [MainActivityInstrumentedTest](src/androidTest/java/com/tazkiyatech/app/MainActivityInstrumentedTest.kt) class to see the problem.

Note that moving the `addFragmentContainerView()` call in [MainActivity](src/main/java/com/tazkiyatech/app/MainActivity.kt) from the `onStart()` method to the `onCreate(savedInstanceState:)` method fixes the failing test method.

##### Links

* See [here](https://issuetracker.google.com/issues/187105532) for the item in IssueTracker which has been created for this bug.
* See [here](https://stackoverflow.com/questions/67322220/) for a StackOverflow thread which describes why this bug is problematic.

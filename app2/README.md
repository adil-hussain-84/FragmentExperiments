# Fragment restoration bug when Fragment is added in another Fragment

This Android application demonstrates that a Fragment does not re-attach to its View on Activity recreation when the View is added to the View hierarchy at any point after the `Fragment.onViewCreated(view:savedInstanceState:)` lifecycle method.

Run the `recreate_activity()` test method in the [MainActivityInstrumentedTest](src/androidTest/java/com/tazkiyatech/app/MainActivityInstrumentedTest.kt) class to see the problem.

Note that moving the `addFragmentContainerView()` call in [ParentFragment](src/main/java/com/tazkiyatech/app/ParentFragment.kt) from the `onStart()` method to the `onViewCreated(view:savedInstanceState:)` method fixes the failing test method.

##### Links

* See [here](https://issuetracker.google.com/issues/187105532) for the item in IssueTracker which has been created for this bug.
* See [here](https://stackoverflow.com/questions/67322220/) for a StackOverflow thread which describes why this bug is problematic.

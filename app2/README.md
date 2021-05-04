# Fragment restoration bug when Fragment is added in another Fragment

This Android application demonstrates that a Fragment does not re-attach to its View on Activity recreation when the View is added to the View hierarchy at any point after the `Fragment.onViewCreated(view:savedInstanceState:)` lifecycle method.

Run the `recreate_activity()` test method in the [MainActivityInstrumentedTest](app2/src/androidTest/java/com/tazkiyatech/app/MainActivityInstrumentedTest.kt) class to see the problem.

Note that moving the `addFragmentContainerView()` call in [ParentFragment](app2/src/main/java/com/tazkiyatech/app/ParentFragment.kt) from the `onStart()` method to the `onViewCreated(view:savedInstanceState:)` method fixes the failing test method.

##### Additional links

* See [here](https://issuetracker.google.com/issues/180538371) for a closed issue in IssueTracker which should have fixed this issue in version [1.3.1](https://developer.android.com/jetpack/androidx/releases/fragment#1.3.1) of the [fragment](https://developer.android.com/jetpack/androidx/releases/fragment) library.
* See [here](https://stackoverflow.com/questions/67322220/) for a StackOverflow thread which describes why this bug is problematic.

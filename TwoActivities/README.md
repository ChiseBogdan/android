When device is rotated, state (information) may be lost.
To persist that information, one can use onSaveInstanceState to store it in the Bundle;

Lifecycle
onPause -> onSaveInstanceState -> onStop

In this project we have 2 Activities:
Main Activity sends Text to Second Activity and Second Activity replies to Main Activity with another Text. Each message received is displayed.

In Main Activity if screen is rotated, in case of a displayed reply message, it will vanish.
To solve this problem, the message and the visibilty of it (if there is a reply message the visibility is true, otherwise fales) is persisted using Bundle state.

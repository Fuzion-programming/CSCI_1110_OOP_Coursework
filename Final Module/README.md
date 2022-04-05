# Final Project

## Synopsis
A simple media player that runs with Java

## Motivation
I built this as a stepping stone to further my knowledge about media objects and sounds. Hoping to use this as a springboard for further projects.

## How to Run
Nothing special necessary to run. Note though that after you press play the player will stall for a few moments to get the song duration so the horizontal slider can seek a new spot on the track

## Code Example
This is an example of the code that went into creating the vertical slider that adjusts volume
```	    
slVertical.valueProperty().addListener(ov -> mediaPlayer.setVolume(slVertical.getValue() / 100));

```

## Tests
No tests to speak of

## Contributors
Thank you Jason for your help with the project

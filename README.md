# Galaxy Brick Destroyer

<img src="https://github.com/justin-sem/Galaxy-Brick-Destroyer/assets/93218385/2bfaa2a6-660d-494c-ad49-bd66e60f368f" width="600" height="400">
![image|50x50](https://github.com/justin-sem/Galaxy-Brick-Destroyer/assets/93218385/2bfaa2a6-660d-494c-ad49-bd66e60f368f )



This is a simple arcade video game.
Player's goal is to destroy bricks with a ball.

The game has very simple commands:

- **SPACE**, to start and pause the game.

- **A / <--** to move the paddle to the left,
 **D / -->** to move the paddle to the right.

- **ESC**, to enter or exit the pause menu.

- **ALT + SHITF + F1**, to open the debug console.

The game will also automatically pause if the frame lost focus.

Enjoy ;-)

****************************************************************
This project is about maintaining and extending a re-implementation of a classic 
retro game, Brick Breaker from: https://github.com/FilippoRanza/Brick_Destroy

**Code Refactoring** 
- **Refactoring & Basic Maintenance**

  The original project is refactored in order to make the code more 
  efficient and maintainable. Classes had been organised in a meaningful 
  way into packages and large classes had broken down to support the idea
  of single responsibility as well as improving encapsulation. All the 
  classes, methods, and fields or variables were renamed for easier understanding
  of the code. Unused resources such as inMiddle and jumps methods, as well as 
  related fields and variables were removed. Adding private visibility to all possible 
  variables and methods is completed to improve the code encapsulation.

- **JUnit Tests**

  To provide annotation to identify the test methods, meaningful JUnit 5 tests had been 
  performed on the methods in this project as much as I could. All the tests were successful.
  JUnit test are store in "JUnit test" folder.


- **Build Automation Tool**

  To automate the creation of executable applications from source code, Maven had been used
  to compile the source code of this project to machine code. The jar file is available under
  "target" folder.





**Additional Features**

  - Game Guide is added and player can access it at the home menu for better understanding of 
  this game.


  - Messages in the game is updated and player can now control the paddle with <-- / --> instead
  just key A and key D.


  - Some modification also added to the game frame. Such as, image icon of the frame and whole design
  of the game is improved for better visualization. Player also cannot change the frame size now.


  - New level for this game is also added, which I introduce a new brick element, Diamond Brick. All other
  bricks also changed to a suitable element.


  - Some game logic also modified such as increase the minimum speed of the ball and increase the probability
  for breaking the gold brick and diamond brick. Gold brick (which previously is steel) had added the crack 
  visibility.


  - A High Score pop up screen had added and will display after each round ended. The scores write and store 
  to a permanent high score list (.txt) which keep in "Others" directory.


  - Background music also added to the game, (.wav) can be found as well in the "Others" directory.


**Javadocs**

  Javadocs for this project can be found under "Javadocs" folder. This source code documentation is aim 
  to increase our code readability, which make the code easier to understand. Javadocs documentation is 
  generated and comments were added to all the classes and methods in this project.

**Thanks a lot :)**
  

                                                        

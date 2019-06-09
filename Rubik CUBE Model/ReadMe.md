# Simple Rubix 3x3 Cube API Model

## CUBE Description:

6 SIDES... [ __FRONT__, __BACK__, __LEFT__, __RIGHT__, __TOP__, __DOWN__ ]

Each side has 9 pieces...

DEFAULT COLORS SCHEME( You can change the color Scheme by Editing the Code ):

```
FRONT 	|	WHITE
BACK 	|	YELLOW
LEFT 	|	RED
RIGHT 	|	ORANGE
TOP 	|	GREEN
DOWN 	|	BLUE
```

## Interface Methods:
* rotateFront(boolean anticlockwise)
* rotateBack(boolean anticlockwise)
* rotateTop(boolean anticlockwise)
* rotateDown(boolean anticlockwise)
* rotateLeft(boolean anticlockwise)
* rotateRight(boolean anticlockwise)

> Boolean Value represents either the cube is rotated Anticlockwise or not!

* isSolved()
* scramble()
* scramble(int times)

You can rotate the cube in clockwise and anti-clockwise direction both...

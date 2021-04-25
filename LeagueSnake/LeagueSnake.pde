//*
// ***** SEGMENT CLASS *****
// This class will be used to represent each part of the moving snake.
//*

class Segment {

//Add x and y member variables. They will hold the corner location of each segment of the snake.
  int x;
  int y;

// Add a constructor with parameters to initialize each variable.
  Segment(int x, int y){
  this.x = x;
  this.y = y;
  }
}

//*
// ***** GAME VARIABLES *****
// All the game variables that will be shared by the game methods are here
//*

//part 1
Segment head;
int foodX;
int foodY;

//part 2
int direction = UP;
int foodeaten = 0;
int newfoodeaten;

// part 3
ArrayList<Segment> tailsegment = new ArrayList<Segment>();

//*
// ***** SETUP METHODS *****
// These methods are called at the start of the game.
//*

void setup() {
  size(500,500);
  head = new Segment(10,10);
  frameRate(20);
  dropFood();
}

void dropFood() {
  //Set the food in a new random location
  foodX = ((int)random(50)*10);
  foodY = ((int)random(50)*10);
}



//*
// ***** DRAW METHODS *****
// These methods are used to draw the snake and its food 
//*

void draw() {
  background(0,0,0);
  drawFood();
  drawSnake();
  eat();
  move();
}

void drawFood() {
  //Draw the food
  fill(225,0,0);
  rect(foodX, foodY, 10, 10);
}

void drawSnake() {
  //Draw the head of the snake followed by its tail
  fill(0,0,225);
  rect(head.x, head.y, 10, 10);
  manageTail();
  drawTail();
}


//*
// ***** TAIL MANAGEMENT METHODS *****
// These methods make sure the tail is the correct length.
//*

void drawTail() {
  //Draw each segment of the tail 
  for (int i = 0; i < tailsegment.size(); i = i+1) {
    Segment s = tailsegment.get(i);
    rect(s.x, s.y, 10, 10);
  }
 }

void manageTail() {
  //After drawing the tail, add a new segment at the "start" of the tail and remove the one at the "end" 
  //This produces the illusion of the snake tail moving.
  checkTailCollision();
  drawTail();
  Segment newseg = new Segment(head.x, head.y);
  tailsegment.add(newseg);
  tailsegment.remove(tailsegment.get(0));
  //tailsegment.remove(0);
}

void checkTailCollision() {
  //If the snake crosses its own tail, shrink the tail back to one segment
  for(int i = 0; i < tailsegment.size(); i = i+1){
    if(head.x == tailsegment.get(i).x && head.y == tailsegment.get(i).y){
      foodeaten = 0;
      tailsegment = new ArrayList<Segment>();
      Segment newseg = new Segment(head.x, head.y);
      tailsegment.add(newseg);
    }
  }
}



//*
// ***** CONTROL METHODS *****
// These methods are used to change what is happening to the snake
//*

void keyPressed() {
  //Set the direction of the snake according to the arrow keys pressed
  if(keyCode == UP){
    direction = UP;
  }
  else if(keyCode == DOWN){
    direction = DOWN;
  }
  else if(keyCode == LEFT){
    direction = LEFT;
  }
  else if(keyCode == RIGHT){
    direction = RIGHT;
  }
}

void move() {
  //Change the location of the Snake head based on the direction it is moving.

    checkBoundaries();
  
  switch(direction) {
  case UP:
    // move head up here 
    head.y -= 10;
    break;
  case DOWN:
    // move head down here 
    head.y += 10;
    break;
  case LEFT:
   // figure it out 
   head.x -= 10;
    break;
  case RIGHT:
    // mystery code goes here 
    head.x += 10;
    break;
  }
}

void checkBoundaries() {
 //If the snake leaves the frame, make it reappear on the other side
 if(head.x == 510){
   head.x = 0;
 }  
 else if(head.x == 0){
   head.x = 500;
 }
 if(head.y == 510){
   head.y = 0;
 }
 else if(head.y == 0){
   head.y = 500;
 }
}

void eat() {
  //When the snake eats the food, its tail should grow and more food appear
  if( head.x == foodX && head.y == foodY){
    dropFood();
    newfoodeaten = foodeaten + 1;
    foodeaten = newfoodeaten;
    Segment newseg = new Segment(head.x, head.y);
    tailsegment.add(newseg);
  }
}

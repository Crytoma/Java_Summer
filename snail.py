reachedTopOfPole = False
currentHeight = 0
currentDay = 1       
h = 10
a = 3
b = 2
#While we have not reached the top.
while reachedTopOfPole != True:
    if currentHeight + a >= h:
        print("Ladies and gentlemen. The snail has reached the summit.")
        reachedTopOfPole = True
    else:
        currentHeight += (a - b);
        currentDay += 1;
print("The snail has reached the top of the pole on day ",currentDay);
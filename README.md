# MyPolynom

This project is about Polynoms, creating and handling them in Java, including some
useful functions I will describe in this document.

The Monom:
Monom is a mathematical function represent by ax^b. the variables are:
Coefficient: a double that represent a.
Power: an int that represent b.

The functions of the Monom are:

Getters/Setters : to adjust an existing Monom.

Constructors:
Monom(double a, int b): Set a new Monom with coefficient=a and power=b.
Monom(Monom ot): Set a new Monom equal to the ot Monom.
Monom(String s): Set a new Monom with values converted of the String.

Functions:
add(Monom m): add m to our Monom.
subtract(Monom m): to subtract m from our Monom.
multiply(Monom m): to multiply to our Monom.
equals(Monom other): check and return if other Monom equals to ours.
makeZero(): to make our Monom's value equal 0.
IsZero(): to check and return if Monom equal 0.
derivative(): returns new Monom which is the derivative of our Monom.
f(double x): to compute the value of the Monom at point x.
toString(): prints the Monom in the form of ax^b.

The Polynom: 
Polynom is a collection of Monoms, in the shape of ArrayList<Monom>.
  
The functions of the Polynom are:

Constructors:
Polynom(): Set place in the memory for new empty Polynom.
Polynom(String s): Set a new Polynom with values converted out of s.

Functions:
f(double x): return the value of the Polynom at point x.
add(Polynom_able p1): get a Polynom and add him to our Polynom.
add (Monom m1): get a Monom and add it to the our Polynom.
substract(Polynom_able p1): get a Polynom and subtract it from the our Polynom.
subtract(Monom m1): get a Monom and subtract it from our polynom.
multiply(Polynom_able p1): get a Polynom and Multiply it with our Polynom.
equals(Polynom_able p1): get a Polynom and return true if the Polynoms are equal.
isZero(): return true if the Polynom is equal to 0.
root(double x0, double x1, double eps): get x0 and x1 and return the intercept with
the x axle by a offset of eps.
copy(): return a deep copy of our Polynom.
derivative(): return a new Polynom which is a derivative of our Polynom.
area(double x0, double x1, double eps): get x1 and x0 and return the area between
them, computed in Riemann sum.
toString(): create a String which is equal to the Polynom.
Iterator<Monom> iterator(): pointer to our Polynom parts.
Multiply(Monom m1): multiply our Polynom by m1.
sortP(): this function sort our Polynom so larger power Monoms will appear first.

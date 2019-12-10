# MyPolynom

This project is about Polynoms, creating and handling them in Java, including some
useful functions I will describe in this document.



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

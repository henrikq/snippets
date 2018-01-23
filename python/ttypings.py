from typing import List
Vector = List[float]


def scale(scalar: float, vector: Vector) -> Vector:
    return [scalar * num for num in vector]


# typechecks; a list of floats qualifies as a Vector.
new_vector = scale(2.0, [1.0, -4.2, 5.4])
print(new_vector)

# will produce error:
new_vector = scale("foo", [1.0, -4.2, 5.4])
print(new_vector)

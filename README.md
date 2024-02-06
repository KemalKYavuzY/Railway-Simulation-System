# Railway Simulation System

This Java project implements a railway simulation system that allows modeling and simulation of trains moving along tracks of different types. The system provides a set of classes representing various track elements and their functionalities.

## Track Elements

### AbstractLink

Abstract base class for implementations of the Crossable interface. Provides default implementations of methods `getNumPaths()` and `shiftPoints()` that are appropriate for classes that have a single entry and exit point and do not rotate.

### CouplingLink

Represents a coupling link that connects two paths at their endpoints, allowing a train to move from one path to the other.

### DeadEndLink

Represents a dead end link, a link with a single endpoint that does not connect to any other links.

### MultiFixedLink

Represents a fixed link between multiple paths, allowing a train to proceed along each path in sequence without the ability to switch paths.

### MultiSwitchLink

Represents a switch between multiple paths, allowing a train to proceed along any of the paths from a common entry point.

### StraightLink

Represents a link between two paths that are straight and continuous, allowing a train to continue straight across the link to the other path.

### SwitchLink

Represents a switch between two paths, allowing a train to proceed along either path from a common entry point.

### TurnLink

Represents a link between two paths that involves a turn, allowing a train to turn onto a third path before continuing straight across to the other path.

## Getting Started

To get started with using the railway simulation system, you can clone this repository and explore the provided classes. You can use these classes to construct a railway network and simulate train movements.

## Contributing

Contributions to this project are welcome. You can contribute by fixing bugs, adding new features, or improving the documentation. Please fork this repository, make your changes, and submit a pull request.

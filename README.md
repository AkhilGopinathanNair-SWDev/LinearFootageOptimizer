**Linear Footage Optimizer**
The Linear Footage Optimizer is a Java application that calculates the optimal linear footage of a list of line items for freight shipments. 
It considers the dimensions and properties of each line item, such as length, width, height, stackability, and turnability, to organize the items within a truck and minimize the space used. 
The goal is to calculate how much length of the truck is used, considering stackable and turnable items, and round the result to the next whole number. The application assumes that the truck has infinite length.

**Features**
Calculates the optimal linear footage for a list of line items.
Considers stackability and turnability of items.
User-friendly interface for entering truck dimensions and line item details.

**Usage**
Run the LinearFootageOptimizerApplication class.
Follow the prompts to input the dimensions of the truck and the details of each line item.
The application will calculate and display the optimal linear footage.

**Examples**
1 pallet @ 48 L x 48 W x 32 H is 2 linear feet.
2 pallets @ 48 L x 48 W x 32 H is 4 linear feet.
2 pallets @ 48 L x 48 W x 32 H, stackable, is 2 linear feet.
1 pallet @ 48 L x 62 W x 32 H is 4 linear feet.

Enjoy optimizing freight shipments with the Linear Footage Optimizer!!!

## Boilerplate

This is a folder to get a quick java MVC program get going

## Folder contents

- `model`
- `view`
- `controller`
- `entry`: Program entry
- `library`: Including set of I/O and validations code

## Work flow

- Program go from `entry` -> `view` -> `controller`

- In `view`, you would want to take user input, validate and call controller functions. Also, you can instantiate any objects needed there and pass to the controller's functins

- In `controller` you would want to handle objects/ informations passed from `view` and update your model accordingly

## How do I use library

- For I/O (eg getInt(), getString(),...):

> `int num = library.getInt();`

or

> `int num = library.getInt("Your error msg here");`

if user enter nothing, a specific num/string will be returned, so check that out

- For validate():

> `validate.validate("Error msg", value, p -> p.doSth() == value)`

Then in your code, catch the Exception generated by validate

If you don't understand predicate, learn it.

# Remember to remove what you don't need or else your project will get heavy and exceeds LOCs

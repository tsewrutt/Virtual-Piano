# CS3035 – Course Project Description

## Description of Your Project

Below, provide a short description of what your project is, how it works, and why you selected this as your project.



## Requirements

I Selected this project since I already had some sort of idea of doing a similar application before.

- How/What different views did you provide for some aspect of your model?
> My Application has 3 different view component: Piano; About; Theme;
 Most of my model is to create the Piano by setting up Majorkeys and Minorkeys and grabbing all the necessary file for the keys to be constructed
 It also has a setKey function which I use to statically assign KeyCodes to the major and minor keys, so I can change my view on handling the assigned key press

- What custom widget did you create in your application?
> The application has Instruments , but due to time I made only one instrument, the Piano.
 When the Other menu is clicked on the menubar, a sliding left navigation bar shifts to the right, which provides the user from accessing the different component of the view 

- What are the different domain objects that can be created/edited in 
your application?
> I have TextField set up for each instrument[ which is being used as a NoteSheet], this text field is binded to my keyboard KeyEvents, for each key presses, the field is updated by writing the Pressed Key Note on the Piano.
The text field has a clear button with it, which allows the user to Clear out the Note Sheet and restart again.
 
 > In the ThemeScene, I have a cool view to allow the Selection of themes.
 > As we click the pane with the dedicated theme, the background of our entire Borderpane is set to that theme
 
 
- What parts of the application/project did you find particularly challenging? 
> Honestly trying not to get Out of Memory space constantly, since I used a lot of images
 But other than that, I'd say setting up the Piano StackPane and getting the Audio set up for all the keys
 I am very much proud of the algorithm I have. It involves The piano being split in 5 chunks and each chunks have 5 minor keys and 7 majors , then I kept looping to create the 5 chunks. [Each Major and Minor key is its own Pane which holds a Canvas]
 
- And, what would you have liked to improve?
>Fixing the Layout a little bit more.Right now, changing the theme is essentially just switching between images, but I wanted to make it so it sets up different color scheme for the other componenet of my Scene as well, e.g the Menubar could have change colour based on different themes I chose

- Any  other comments on the course project?
> Make sure you try the "????" button in the Left Side Tool pane


REFERENCES:

>https://virtualpiano.net/ - A similar website to what I invisioned
>https://archive.org/details/A262398373B1 - where I found all the piano notes sound
>https://web.microsoftstream.com/video/3c1d4072-9749-4e29-adab-de1326ea0bfc?list=studio - VIDEO LINK




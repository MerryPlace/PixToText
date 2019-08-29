# PixToText

The runnable jar file can be found here: https://github.com/NoahOrtega/PixToText/blob/master/dist/PicToText.jar

This program takes a png image as input and asks you to choose characters to represent colors in the image. The output is a replica of the image translated into text which can be coppied and pasted elsewhere. It works best with pixel art that doesn't use very many colors, but if you have the patience to enter a character for every present color it should work with any image.

This program was designed as a tool to assist in the creation of wings for the minecraft server plugin "Custom Wings" which uses designs specified in a txt to draw wings on the player in game. 
The wonderful plugin can be found here: https://github.com/Tigeax/CustomWings


## Examples:  

![Ex1 input/output](https://pbs.twimg.com/media/EDJyvSMX4AAlkk1?format=png&name=small)   
## GUI:  

![GUI](https://pbs.twimg.com/media/EDJyvSLW4AAV-zg?format=png&name=large)   

## Notes:  

* When pasting the text elsewhere you need to use a font which has each character take up the same width such as Courier. otherwise the 'image' can be severely distorted.

* At the moment you have to be careful with fully transparent pixels not always being grouped together. Despite a pixels alpha being 0 (fully transparent) it's RGB values can still be different if the program you use does not properly set these values when erasing. ex: R:255 G:255 B:255 A:0 is a black clear pixel while R:0 G:0 B:0 A:0 is a white clear pixel; these will be grouped seperately.

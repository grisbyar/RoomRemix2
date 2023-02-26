
# Introduction
### Name: Room Remix
Alexander Grisby
Brian Kenkel
Ben Devine

In a world of online shopping, it’s hard to be able to plan your perfect home layout. 
Use Room Remix to fully plan out your living space.
+ Upload floorplans once
+ Drag and Drop furniture and arrange it to see multiple different mockups
+ Be able to rearrange a room without leaving your couch to see 
+ Get Ideas straight from the app 
+ Browse Furniture and be able to test different types in your room from the app
+ Develop a budget for it
If you’re moving to a new place, or trying to reimagine your current place, imagine it with INSERT APP HERE.

---
# Storyboard (screen mockups): Invision, FluidUI, Powerpoint, paint, etc... will be fine.
## Main Screen
+ Left Sidebar with folders?
+ Floorplan entry
+ Link to Pinterest with Interior Decorating Ideas
+ Link to Shopping sites with AR view?
+ Last opened Floorplan is there
+ On right, shapes that can be dragged and dropped, representing different pieces of furniture

## Floor plan entry
+ Asks you to enter dimensions of the room, maybe draw it? And auto straightens lines
+ Asks where windows and doors are
+ Asks for a name to be saved under


## Floor Plan design - Main screen
+ Floor plan of previous opens up
+ Has furniture preloaded, sizes to scale
+ Can add own furniture


## Furniture Picker
+ Opens menu for link to product or browse
+ Tries to scrape data off website [ not feasible in time frame probably, considering data is everywhere and not consistent]
+ Asks for dimensions
+ Adds to menu


## Ideas
+ List of topics/tags
+ Pulls up relevant pinterest showings
---
# Functional Requirements in the format (fill in the square brackets with your own words):

## MVP 100.1:
As a User, I want to be able to visualize my floor plan and dimensions so that I can know the dimensions of it.
Dependencies - None currently
### Example 1:
+ Given a set of dimensions [ parameters: dimensions]
+ When I enter them
+ Then The room with the set of dimensions is rendered

### Example 2: 
+ Given a canvas [ parameters - user input]
+ When I draw on it for an odd room layout
+ Then the lines straighten and ask for dimensions
### Example 3 [ Not sure if possible ] :
+ Given an image of a floor plan [ parameters - test image]
+ When it gets translated by the app
+ Then it translates into a useable format
## MVP 100.2:

As a user, I want a way to visualize furniture pieces so that I can arrange them to my liking.
### Example:
+ Given a Floorplan
+ When I decorate it
+ Then I can visualize dimensions

### Example:
+ Given a Floorplan
+ When I use the furniture tab
+ Then I can drag and drop furniture

## MVP 100.3:
As a user, I want a way to add new furniture pieces from either online or custom ones so that I can use new furniture in my plans.

### Example:
+ Given a new piece of furniture
+ When I enter it in
+ I can use it to decorate the area.

### Example:
+ Given a submitted piece of furniture
+ When I add it to my selections
+ I can use it to decorate the area

## MVP 100.4:
As a user, I want a way to be able to store floorplans that I’ve made and bring them up again so that I can reference them.

### Example:
+ Given a already customized floorplan
+ When I save the floorplan
+ Then it shows up as something to compare to

### Example:
+ Given a list of customized floorplans
+ When I select one
+ Then  I can continue without having to start over

## MVP 100.5:
As a user, I want to be able to find inspiration in other designs so that I can customize around that.

### Example:
+ Given a set of tags
+ When I can look up various floorplans
+ Then I can use them as inspiration for mine

### Example:
+ Given a search term
+ When I look up the term I can find floorplans
+ Then I can use them as inspiration for mine



---
# Class Diagram
Show data classes (DTOs), Activities, Fragments, MVVM, etc.
I use ArgoUML to model classes in a diagram.  Other tools work as well.


# Class Diagram Description
One or two lines for each class to describe  use of interfaces, JME classes, Dalvik (Android) classes and resources, interfaces, etc.  Don't worry about putting more than a few words to each class; this does not need to be thorough.
---
# A Product Backlog
## Version 200.1:
WIP Stories
+ I can visualize an entire building with this
+ I can use design options such as colors, wallpapers
+ I can not have to enter dimensions from online storefronts
+ I can compare multiple pieces of furniture with an easy interface
+ I can use AR to visualize what would fit in the floorplan.
+ There should be a budget for each floorplan
+ There should be notes for each floorplan

Each story should be a separate Project in GitHub.  The title of the project should be the name of the story.
As long as you have these stories listed as Projects in GitHub, I can look at your projects to see your backlog.  No need to repeat it in the design document.

---
# A scrum or kanban board, using GitHub projects (preferred), Trello, Scrumy.com, or something similar, that contains:

A milestone for Sprint #1, with tasks associated.
Tasked stories for Sprint #1
Sprint tasks that elaborate on the stories, with technical details.
These should be technical tasks that are required to implement one of the features.
You only need to task out stories for Sprint #1.  You can task out stories for Sprint #2 and #3 as we get closer to those sprints.
The Product Owner/Scrum Master/DevOps person on your team should select stories to play for each sprint, from the list of available stories in the Product Backlog.
As long as you have the tasks in GitHub Projects, under Projects, and associated with milestones, you do not need to repeat them in the design doc.  I'll look at the Project and Milestone view to see them.
---
# Scrum Roles, and who will fill those roles
DevOps/Product Owner/Scrum Master: Alexander Grisby /Ben Devine
Frontend Developer: Alexander Grisby / Brian Kenkel /Ben Devine
Integration Developer: Alexander Grisby / Brian Kenkel / Ben Devine

---
# Communication tool you will use for your 8:00 Sunday group stand up (Zoom, Teams, etc.)  If you choose a different tool and/or different time, that's fine, just indicate it in the document.
Teams/Zoom

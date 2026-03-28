# CPSC449 Midterm Project: Event Ticketing System
*By Madeline Savoiu (884984097)*

## Overview

The backend application is split into three logical tier by folder: the controller, service, and repository layer. The files in the controller layer contain the definitions for required API routes for each entity. The service layer contains calls to the repository layer and functions containing underlying business logic that are called by the controllers.

The application also defines several data transfer objects (DTOs) for passing information between the application's layers. These include the required DTOs outlined in the assignment, as well as other DTOs create to make API route development smoother.

[Demo video](https://youtu.be/25pgGE0kCOc)

## API Testing
### POST /api/organizers
![img](readme_images/POST:api:organizers.png)
### POST /api/venues
![img](readme_images/POST:api:venues.png)
### POST /api/events
![img](readme_images/POST:api:events.png)
### POST /api/attendees
![img](readme_images/POST:api:attendees.png)
### POST /api/bookings
![img](readme_images/POST:api:bookings.png)
### POST /api/bookings/{id}/cancel
![img](readme_images/POST:api:bookings:{id}:cancel.png)
### GET /api/events
![img](readme_images/GET:api:events.png)
### GET /api/events/{id}
![img](readme_images/GET:api:events:{id}.png)
### GET /api/events/{id}/revenue
![img](readme_images/GET:api:events:{id}:revenue.png)
### GET /api/attendees/{id}/bookings
![img](readme_images/GET:api:attendees:{id}:bookings.png)

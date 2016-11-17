# RouteCondition

# Goal
A mobile app to tell riders/drivers following information based on ‘crowd sourced’ data.
 1. Road condition.
 2. Best Route from A to B

## Motivation
- No easy, accurate way to find which route to take based on road condition, safety etc. Google Maps is 95% good for cities and probably 50% for long distance touring (in India).
- Our only option is to find friends or connect with awesome communities like below where people selflessly give such detail information about every Km. Very thorough and detail data, unfortunately 'too much data' and sometimes it gets overwhelming and we are not able to make decision until we 'ask' our question. Vision is to have an app where users just update data and finding route condition should be easier.
  - http://www.team-bhp.com/forum/route-travel-queries/
  - http://www.bcmtouring.com/forums/forums/road-status.90/
  - https://www.facebook.com/groups/hvkumar/
  - xBHP

## Road condition:
Rider/Driver can give following information about a specific route
- Road type (todo: define)
  - Tar / untar etc
  - Number of lanes
  - Toll / no Toll
- Usual traffic situation
- Extras
  - Scenic or not
  - Food options available or not
  - Fuel stations available or not
  - Safety
- Tag Pictures

## How:
1. Three ways to update road conditions
  - Let user choose sections of a road (may be limit to x KM) on the map and rate it on specific scale.
  - Give start/stop trip option. User starts the trip and then updates condition on the road by placing markers (possibly voice integration)
  - Auto. When on a trip, phone tries to guess road condition (using various sensors)
2. How to show all the information collected?
  - Let user select a route by giving source / destination and then color that route based on community's input. Let user tap on specific section to see what others are saying about it.
    - Let user filter to see inputs by user, by date etc
  - Extra features
    - Show contributors to specific route info
    - Let people message each other
    - Set up alerts i.e. if anyone posts anything about this section alert me.
    - Request for road condition and message goes to everyone 'around' that location. (Have to be careful about privacy)


## RnD (move this to another doc or create tasks):
- Can we update mobile sensor to identify hump, pothole, jerks (bad road conditions).
- Custom color coding the roads in the google maps to specify good or bad road.
- Getting sub-routes from a trip route.
- Pushing data in the google database / storage (Firebase)
- Finding existing data on road condition which can be consumed as a service by our app.



## Technology:
- Android (7.0)
- Google maps
- Google play service
- Firebase - for database / storage, FCM, analytics, crashlytics, testing in devices
- Android Studio


### Notes:
- Looks like google is retiring mapmaker: https://support.google.com/mapmaker/answer/7195127?p=graduation&rd=1


### Resources:
- https://developers.google.com/maps/documentation/api-picker

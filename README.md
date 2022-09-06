# Code BNB 

<img width="600" alt="Screenshot 2022-09-06 at 14 26 43" src="https://user-images.githubusercontent.com/69481095/188647243-7d71cf51-2691-4dc7-8332-07fd7c344254.png">

## Capstone project for CodeClan Software Develeopment

This repository is only for the back end code, to see the front end code please visit => https://github.com/Cetins/bnb-front-end 

## About

This is a property rental application, my reference point is AirBnb. Home page lists all the properties and if you click on the "more" you'll be redirected to the property page and see the details for the property. Additionally you can click on the cover gallery module to access all images of the related property in a different page.

<img width="600" alt="Screenshot 2022-09-06 at 14 29 14" src="https://user-images.githubusercontent.com/69481095/188653677-3f2debe0-c8ab-46eb-8e7f-cb7f630a4010.png">

### React

I've used `"react-router-dom": "^6.3.0"` for routing in this app. It creates a convenient page routing for react without causing so much trouble and still giving the single-page-app functionality with React. All components designed from scratch, no additional library used. Same goes for the styling, I didn't use any dependancy, it's all vanilla CSS.

<img width="464" alt="Screenshot 2022-09-06 at 14 32 32" src="https://user-images.githubusercontent.com/69481095/188653343-ace3b762-f72d-4eeb-9ed2-d55e79ec7661.png">

### Auth0

This was a simple set set up via Auth0 website. In this version there isn't any customization in functionality so nothing complicated. If you want to recreate this project for educational purposes, I would suggest to follow instructions in Auth0 website. As far as I see they update their documentation regularly and set up is really easy. 

<img width="227" alt="Screenshot 2022-09-06 at 14 32 48" src="https://user-images.githubusercontent.com/69481095/188653996-8fe0c319-3477-479b-aee9-2efa2de74ad0.png">

Right now Auth0 is not storing data in my own database. In the account page users can see their reviews and bookings. In `App.js` there is a `findGuestByEmail` function which matches the email information comes from Auth0 with the email information of `Guest` in local db. 

<img width="600" alt="Screenshot 2022-09-06 at 14 33 22" src="https://user-images.githubusercontent.com/69481095/188663640-71573f21-449c-45c9-bf93-c45629ad36b2.png">

## Goals

This project solely created for educational purposes therefore the languages, frameworks selected here is not intented for real life. In CodeClan we've been taught 3 main languages; Python with Flask, Javascript with React and Java with Spring. In every module we learned and practiced how to work within one language. After completing Java Module I've decided to branch my knowledge and bring together all the things I've learned. I intentionally discard Python because I've already had lots of opportunity to work with it and overall it was the most compfortable language for me. So I've decided to work with React and Java. If you think it wasn't the best choice, it's ok. 

## How to reproduce 

### Back-end

I've used IntelliJ during this project and still my favorite by the time being, so I strongly suggest to download community version (it's free) if you are fairly new in Java. Select `open` project option in the first interface and let IntellJ build it for you. Click on the `run` icon on the top menu or right click the `BnbApplication` in the file directory and select `Run BnbApplication`. At this pont you should see the `BnbApplication started ...` on the bottom of the console. If you happen to see any errors feel free to open an issue here => https://github.com/Cetins/bnb-back-end . I like debugging and happy to help you when availability happens. 

### Front-end

After cloning the project folder in your local machine open it with your choice of IDE. Open your internal terminal in the project folder or open any terminal and `cd` to your project directory. Run `npm install`  If you don't have npm installed globally you can visit https://www.npmjs.com/package/npm and follow instructions. After run `npm start` to publish project on the browser. Please make sure your back-end server is running before start your React project. For problems feel free to open issues in here => https://github.com/Cetins/bnb-front-end 

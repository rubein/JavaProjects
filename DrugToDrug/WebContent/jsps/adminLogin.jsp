<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <link href="ddmenu.css" rel="stylesheet" type="text/css" />
    <script src="ddmenu.js" type="text/javascript"></script>
    <style>

	@import "compass/css3";

* { box-sizing: border-box; }

body {
	font-family: "HelveticaNeue-Light","Helvetica Neue Light","Helvetica Neue",Helvetica,Arial,"Lucida Grande",sans-serif;
  color:white;
  font-size:12px;
  background:#333 url(/images/classy_fabric.png);
}

form {
 	background:#111; 
  width:300px;
  height:520px;
  margin:30px auto;
  border-radius:0.4em;
  border:1px solid #191919;
  overflow:hidden;
  position:relative;
  box-shadow: 0 5px 10px 5px rgba(0,0,0,0.2);
}

form:after {
  content:"";
  display:block;
  position:absolute;
  height:1px;
  width:100px;
  left:20%;
  background:linear-gradient(left, #111, #444, #b6b6b8, #444, #111);
  top:0;
}

form:before {
 	content:"";
  display:block;
  position:absolute;
  width:8px;
  height:5px;
  border-radius:50%;
  left:34%;
  top:-7px;
  box-shadow: 0 0 6px 4px #fff;
}

.inset {
 	padding:20px; 
  border-top:1px solid #19191a;
}

form h1 {
  font-size:18px;
  text-shadow:0 1px 0 black;
  text-align:center;
  padding:15px 0;
  border-bottom:1px solid rgba(0,0,0,1);
  position:relative;
}

form h1:after {
 	content:"";
  display:block;
  width:250px;
  height:100px;
  position:absolute;
  top:0;
  left:50px;
  pointer-events:none;
  transform:rotate(70deg);
  background:linear-gradient(50deg, rgba(255,255,255,0.15), rgba(0,0,0,0));
  
}

label {
 	color:#666;
  display:block;
  padding-bottom:9px;
}

input[type=text],
input[type=password] {
 	width:100%;
  padding:8px 5px;
  background:linear-gradient(#1f2124, #27292c);
  border:1px solid #222;
  box-shadow:
    0 1px 0 rgba(255,255,255,0.1);
  border-radius:0.3em;
  margin-bottom:20px;
  color:white;
}

label[for=remember]{
 	color:white;
  display:inline-block;
  padding-bottom:0;
  padding-top:5px;
}

input[type=checkbox] {
 	display:inline-block;
  vertical-align:top;
}

.p-container {
 	padding:0 20px 20px 20px; 
}

.p-container:after {
 	clear:both;
  display:table;
  content:"";
}

.p-container span {
  display:block;
  float:left;
  color:#0d93ff;
  padding-top:8px;
}

input[type=submit] {
 	padding:5px 20px;
  border:1px solid rgba(0,0,0,0.4);
  text-shadow:0 -1px 0 rgba(0,0,0,0.4);
  box-shadow:
    inset 0 1px 0 rgba(255,255,255,0.3),
    inset 0 10px 10px rgba(255,255,255,0.1);
  border-radius:0.3em;
  background:#0184ff;
  color:white;
  float:right;
  font-weight:bold;
  cursor:pointer;
  font-size:13px;
}

input[type=submit]:hover {
  box-shadow:
    inset 0 1px 0 rgba(255,255,255,0.3),
    inset 0 -10px 10px rgba(255,255,255,0.1);
}

input[type=text]:hover,
input[type=password]:hover,
label:hover ~ input[type=text],
label:hover ~ input[type=password] {
 	background:#27292c;
}
	
	
	
	
	h1 { color: #b48608; font-family: 'Raleway',sans-serif; font-size: 62px; font-weight: 800; line-height: 72px; margin: 0 0 24px; text-align: center; text-transform: uppercase; }


h2 { color: #685206; font-family: 'Raleway',sans-serif; font-size: 30px; font-weight: 800; line-height: 36px; margin: 0 0 24px; text-align: center; }


p { color: #685206; font-family: 'Raleway',sans-serif; font-size: 16px; font-weight: 500; line-height: 32px; margin: 0 0 24px; }


a { color: #c8c8c8; text-decoration: underline; }


a:hover { color: #1c1c1c; text-decoration: underline; }
	
	
p1{color: #685206; font-family: 'Raleway',sans-serif; font-size: 18px; font-weight: 500; line-height: 32px; margin: 0 0 24px; }
.form-style-5{
    max-width: 500px;
    padding: 10px 20px;
    background: #f4f7f8;
    margin: 10px auto;
    padding: 20px;
    background: #f4f7f8;
    border-radius: 8px;
    font-family: Georgia, "Times New Roman", Times, serif;
	overflow: auto;
	scrollbar-base-color: #ff8c00;
	scrollbar-arrow-color: white;
}

.long{
overflow: auto;
scrollbar-base-color: #ff8c00;
scrollbar-arrow-color: white;
}
.form-style-5 fieldset{
    border: none;
	overflow: auto;
}
.form-style-5 legend {
    font-size: 1.4em;
    margin-bottom: 10px;
	overflow: auto;
}
.form-style-5 label {
    display: block;
    margin-bottom: 8px;
	overflow: auto;
}
.form-style-5 input[type="text"],
.form-style-5 input[type="date"],
.form-style-5 input[type="datetime"],
.form-style-5 input[type="email"],
.form-style-5 input[type="number"],
.form-style-5 input[type="search"],
.form-style-5 input[type="time"],
.form-style-5 input[type="url"],
.form-style-5 textarea,
.form-style-5 select {
    font-family: Georgia, "Times New Roman", Times, serif;
    background: rgba(255,255,255,.1);
    border: none;
    border-radius: 4px;
    font-size: 16px;
    margin: 0;
    outline: 0;
    padding: 7px;
    width: 100%;
    box-sizing: border-box; 
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box; 
    background-color: #e8eeef;
    color:#8a97a0;
    -webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    margin-bottom: 30px;
    overflow: auto;
}
.form-style-5 input[type="text"]:focus,
.form-style-5 input[type="date"]:focus,
.form-style-5 input[type="datetime"]:focus,
.form-style-5 input[type="email"]:focus,
.form-style-5 input[type="number"]:focus,
.form-style-5 input[type="search"]:focus,
.form-style-5 input[type="time"]:focus,
.form-style-5 input[type="url"]:focus,
.form-style-5 textarea:focus,
.form-style-5 select:focus{
    background: #d2d9dd;
}
.form-style-5 select{
    -webkit-appearance: menulist-button;
    height:35px;
	overflow: auto;
}
.form-style-5 .number {
    background: #1abc9c;
    color: #fff;
    height: 30px;
    width: 30px;
    display: inline-block;
    font-size: 0.8em;
    margin-right: 4px;
    line-height: 30px;
    text-align: center;
    text-shadow: 0 1px 0 rgba(255,255,255,0.2);
    border-radius: 15px 15px 15px 0px;
	overflow: auto;
}

.form-style-5 input[type="submit"],
.form-style-5 input[type="button"]
{
    position: relative;
    display: block;
    padding: 19px 39px 18px 39px;
    color: #FFF;
    margin: 0 auto;
    background: #1abc9c;
    font-size: 18px;
    text-align: center;
    font-style: normal;
    width: 100%;
    border: 1px solid #16a085;
    border-width: 1px 1px 3px;
    margin-bottom: 10px;
	overflow: auto;
}
.form-style-5 input[type="submit"]:hover,
.form-style-5 input[type="button"]:hover
{
    background: #109177;
}	
	
	
#panel {
max-width:1700px;
    position: relative;
    top: 355px;
    right: 0;
	background-color: #DBA901;
    height: 530px;
    
   

}

#rig {
    max-width:1700px;
    position: relative;
    top: 390px;
    right: 0;
 
    height: 740px;
    border: 3px solid #73AD21;
    padding:0;
    font-size:0; /* Remember to change it back to normal font size if have captions */
    list-style:none;
    background-color:#000;
}

#rig li {
    display: inline-block;
    *display:inline;/*for IE6 - IE7*/
    width:25%;
    vertical-align:middle;
    box-sizing:border-box;
    margin:0;
    padding:0;
}
        
/* The wrapper for each item */
.rig-cell {
    /*margin:12px;
    box-shadow:0 0 6px rgba(0,0,0,0.3);*/
    display:block;
    position: relative;
    overflow:hidden;
}
        
/* If have the image layer */
.rig-img {
    display:block;
    width: 100%;
    height: auto;
    border:none;
    transform:scale(1);
    transition:all 1s;
}

#rig li:hover .rig-img {
    transform:scale(1.05);
}
        
/* If have the overlay layer */
.rig-overlay {
    position: absolute;
    display:block;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    margin: auto;
    background: #3DC0F1 url(img/link.png) no-repeat center 20%;
    background-size:50px 50px;
    opacity:0;
    filter:alpha(opacity=0);/*For IE6 - IE8*/
    transition:all 0.6s;
}
#rig li:hover .rig-overlay {
    opacity:0.8;
}

/* If have captions */
.rig-text {
    display:block;
    padding:0 30px;
    box-sizing:border-box;
    position:absolute;
    left:0;
    width:100%;
    text-align:center;
    text-transform:capitalize;
    font-size:18px;
    font-weight:bold;
    font-family: 'Oswald', sans-serif;
    font-weight:normal!important;
    top:40%;
    color:white;
    opacity:0;
    filter:alpha(opacity=0);/*For older IE*/
    transform:translateY(-20px);
    transition:all .3s;
}
#rig li:hover .rig-text {
    transform:translateY(0px);
    opacity:0.9;
}

@media (max-width: 9000px) {
    #rig li {
        width:25%;
    }
}

@media (max-width: 700px) {
    #rig li {
        width:33.33%;
    }
}

@media (max-width: 550px) {
    #rig li {
        width:50%;
    }
}

    body { background: #eee url(hr.jpg) no-repeat center 0px; padding-top:90px;}
    </style>
</head>
<body>
<nav id="ddmenu">
    
    <ul>
        <li class="full-width">
             <span class="top-heading"><a href="home.jpg">Home</a></span>
            
  <li class="no-sub"><a class="top-heading" href="about-us.jpg">About Us</a>
		<i class="caret"></i>
            <div class="dropdown">
                <div class="dd-inner">
                    <ul class="column">
                        <li><h3>Get to know Us!!</h3></li>
                        <li><a href="#"><p>We are international students<br> from India, pursuing a Masters 
						<br>degree from University Of South <br>Florida.</p></a></li>
                    </ul>
                    <ul class="column">
                        <li><h3>Website</h3></li>
                        <li><a href="#"><p>This site is a part of <br>our major project <br>in Advanced databases
						.It's <br>based on drug drug <br>interaction.</p></a></li>
                    </ul>
                    <ul class="column mayHide">
                    </ul>
                </div>
            </div>
        </li>
		</li>
        <li>
            <a class="top-heading" href="contact.jpg">Contact Us</a>
            <i class="caret"></i>
            <div class="dropdown">
                <div class="dd-inner">
                    <ul class="column">
                        <li><h3>We are just a call away!</h3></li>
                        <li><a href="#"><p1>Don't hesitate to drop us a call,<br>message or mail.We will be <br>
						more than happy to help.</p1></a></li>
                    </ul>
					<ul class="column mayHide">
                        <li><br /><img src="tt.png" /></li>
                    </ul>
                </div>
            </div>
        </li>
        <li>
            <span class="top-heading">Drugs</span>
            <i class="caret"></i>
            <div class="dropdown offset300">
                <div class="dd-inner">
                    <ul class="column">
                        <li><h3>Find it all!</h3></li>
                        <li><a href="#"><p>The entire list of drugs along with <br>  their enzyme and their reporting <br>institutes.<p></a></li>
                        
                    </ul>
                    
                    <ul class="column mayHide">
                        <li><br /><img src="df.jpg" /></li>
                    </ul>
                </div>
            </div>
        </li>
        <li class="no-sub">
            <a class="top-heading" href="adminLogin.jsp">Login</a>
        </li>
    </ul>
</nav>
<div id = "panel">
               <form action="Authentication.do" method="post">
  <h1>Employer Log in</h1>
  <div class="inset">
  <p>
    <label for="email">EMAIL ADDRESS</label>
    <input type="text" name="email" id="email">
  </p>
  <p>
    <label for="password">PASSWORD</label>
    <input type="password" name="password" id="password">
  </p>
  <p>
    <input type="checkbox" name="remember" id="remember">
    <label for="remember">Remember me for 14 days</label>
  </p>
  </div>
  <p class="p-container">
   
    <input type="submit" name="go" id="go" value="Log in">
  </p>
				</form>
	</div>	

<ul id="rig">
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Ethanol">
            <img class="rig-img" src="1.png">
            <span class="rig-overlay"></span>
            <span class="rig-text">Ethanol</span>
        </a>
    </li>
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Warfarin">
            <img class="rig-img" src="2.png">
            <span class="rig-overlay"></span>
            <span class="rig-text">Warfarin</span>
        </a>
    </li>
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Mephenytoin">
            <img class="rig-img" src="3.PNG">
            <span class="rig-overlay"></span>
            <span class="rig-text">Mephenytoin</span>
        </a>
    </li>
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Zidovudine">
            <img class="rig-img" src="4.png">
            <span class="rig-overlay"></span>
            <span class="rig-text">Zidovudine</span>
        </a>
    </li>
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Amlodipine">
            <img class="rig-img" src="5.png">
            <span class="rig-overlay"></span>
            <span class="rig-text">Amlodipine</span>
        </a>
    </li>
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Acetic_acid">
            <img class="rig-img" src="6.png">
            <span class="rig-overlay"></span>
            <span class="rig-text">Acetic Acid</span>
        </a>
    </li>
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Oxalic_acid">
            <img class="rig-img" src="7.png">
            <span class="rig-overlay"></span>
            <span class="rig-text">Oxalic Acid</span>
        </a>
    </li>
    <li>
        <a class="rig-cell" href="https://en.wikipedia.org/wiki/Adenosine">
            <img class="rig-img" src="8.png">
            <span class="rig-overlay"></span>
            <span class="rig-text">Adenosine</span>
        </a>
    </li>
</ul>
</body>
</html>
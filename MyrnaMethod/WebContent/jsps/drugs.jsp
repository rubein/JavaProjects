

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <link href="ddmenu.css" rel="stylesheet" type="text/css" />
    <script src="ddmenu.js" type="text/javascript"></script>
	<title>Drug To Drug</title>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script> 
	

</head>
    <style>

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
 
    height: 370px;
    
   

}

#rig {
    max-width:1700px;
    position: relative;
    top: 410px;
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

p { color: #685206; font-family: 'Raleway',sans-serif; font-size: 16px; font-weight: 500; line-height: 32px; margin: 0 0 24px; }
p1{color: #685206; font-family: 'Raleway',sans-serif; font-size: 18px; font-weight: 500; line-height: 32px; margin: 0 0 24px; }
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

    body { background: #eee url(rr.jpg) no-repeat center 0px; padding-top:90px;}
    </style>
</head>
<body>
<nav id="ddmenu">
    
    <ul>
        <li class="full-width">
            <span class="top-heading"><a href="HomePage.jsp">Home</a></span>
            
        <li class="no-sub"><a class="top-heading" href="about-us.jsp">About Us</a>
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
                        <li><br /><img src="rr.png" /></li>
                    </ul>
                </div>
            </div>
        </li>
		</li>
		
        <li>
            <a class="top-heading" href="contact.jsp">Contact Us</a>
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
            <a span class="top-heading" href="drugs.jsp">Drugs</a></span>
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
            <a class="top-heading" href="memberLogin.html">Login</a>
        </li>
    </ul>
</nav>

<div id="panel">

	<iframe allign="centre" height="602" width="430" allign="auto" src="https://docs.google.com/spreadsheets/d/e/2PACX-1vTose7ert3QJsI1nTLqkfQbqtVdafH1OCKsRp0KDGDScZxyQ-aLIasw9PTMV3waoMopew_iIydqW9gX/pubhtml?widget=true&amp;headers=false"></iframe>

</div>

</body>
</html>
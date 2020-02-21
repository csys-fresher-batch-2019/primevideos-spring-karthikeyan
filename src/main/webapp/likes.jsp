<!DOCTYPE html> 
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <style> 
.like, .dislike {
    display: inline-block;
    margin-bottom: 0;
    font-weight: normal;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    background: lightgreen;
    border: 1px solid transparent;
    white-space: nowrap;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.428571429;
    border-radius: 4px;
}
.qty1, .qty2 {
    border: none;
    width:20px;
    background: transparent;
}
 </style> 
            </head> 
<body> 

<div class="container"> 
    <a class="like"><i class="fa fa-thumbs-o-up"></i>  
        Like <input class="qty1" name="qty1" readonly="readonly" type="text" value="100" />
    </a>
    <a class="dislike"><i class="fa fa-thumbs-o-down"></i> 
        Dislike <input class="qty2"  name="qty2" readonly="readonly" type="text" value="0" />
    </a>
</div>

</body> 
</html>
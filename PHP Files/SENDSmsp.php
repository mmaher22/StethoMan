<?php
require "CONN.php";

$msg = urldecode($_POST['msg']);
$totype = urldecode($_POST['table']);
$userid = urldecode($_POST['userid']);
$fromid = urldecode($_POST['fromid']);
$table = "doctor";
if($userid == '0') $table = "manager";
$mysql_qry0 = "INSERT INTO message ( toid, fromid, content, fromtype, totype) VALUES ( '".$userid."', '".$fromid."', '".$msg."', 'patient', '".$table."' )";
$result = mysql_query($mysql_qry0);
if($result) echo "Msg Send";
else echo "Error: UserID is invalid or can not connect to database ".mysql_error();
?>
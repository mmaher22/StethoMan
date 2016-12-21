<?php
require "CONN.php";

$msg = urldecode($_POST['msg']);
$userid = urldecode($_POST['userid']);
$fromid = urldecode($_POST['fromid']);
$table = "patient";
if($userid == '0') $table = "manager";
$mysql_qry0 = "INSERT INTO message ( toid, fromid, content, fromtype, totype) VALUES ( '".$userid."', '".$fromid."', '".$msg."', 'doctor', '".$table."' )";
echo $mysql_qry0;
$result = mysql_query($mysql_qry0);
if($result) echo "Msg Send";
else echo "Error: UserID is invalid or can not connect to database ".mysql_error();
?>
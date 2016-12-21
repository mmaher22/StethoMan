<?php
require "CONN.php";

$msg = urldecode($_POST['msg']);
$totype = urldecode($_POST['table']);
$userid = urldecode($_POST['userid']);

$mysql_qry0 = "INSERT INTO message ( toid, fromid, content, fromtype, totype) VALUES ( '".$userid."', '0', '".$msg."', 'manager', '".$totype."' )";
$result = mysql_query($mysql_qry0);
if($result) echo "Msg Send";
else echo "Error: UserID is invalid or can not connect to database ".mysql_error();
?>
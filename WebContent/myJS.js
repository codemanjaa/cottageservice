function doQuery()
{
//alert('doQuery...');	
	if((document.getElementById('bookerName').value!='')&&(document.getElementById('noOfPlaces').value!='')&&(document.getElementById('noOfRooms').value!='')&&(document.getElementById('noOfDays').value!=''))
	{
		var atDate = document.getElementById('datepicker').value;
		console.log(atDate+ "WRONG "+ atDate + "...Value ");
		var aDate = Date.parse(atDate) || 0;
		console.log(aDate)
		if (aDate == 0){
			aDate = new Date();
			let day = aDate.getDate();
			let month = aDate.getMonth() + 1;
			let year = aDate.getFullYear();
			let pickDate = `${day}.${month}.${year}`;
			console.log(pickDate)
		}
		else{
			
			console.log(aDate == 'NaN.NaN.NaN');
			let tDate = new Date(aDate);
			let day = tDate.getDate();
			let month = tDate.getMonth() + 1;
			let year = tDate.getFullYear();
			let pickDate = `${day}.${month}.${year}`;
			console.log(pickDate)
		}
		var q_str = 'reqType=doQuery';

		q_str = q_str+'&bookerName='+document.getElementById('bookerName').value;
		q_str = q_str+'&nPlaces='+document.getElementById('noOfPlaces').value;
		q_str = q_str+'&nRooms='+document.getElementById('noOfRooms').value;
		q_str = q_str+'&lakeDistance='+document.getElementById('lakeDistance').value;
		q_str = q_str+'&cityDistance='+document.getElementById('cityDistance').value;
		q_str = q_str+'&noOfDays='+document.getElementById('noOfDays').value;
		
		
		
		doAjax('Cottage',q_str,'doQuery_back','post',0);
	}else
	{
		alert('Please, fill all the search fields...');
	}
}

function uuidv4() {
    return 'ties-4520-4xxx-yxxx-xxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}


  function printValues(obj) {
        for(var k in obj) {
            if(obj[k] instanceof Object) {
                printValues(obj[k]);
            } else {
				documekt.writeln("Booking Ref "+ uuidv4());
                document.write(obj[k] + "<br>");
            };
        }
    };
    
/*
// Define recursive function to print nested values
function printOValues(obj) {
	
	//document.write("object length: "+ obj["results"]["bindings"].length);
	for (var k in  obj["results"]["bindings"] ){
		if(k instanceof Object){
			
		}
		else {
			document.write( obj["results"]["bindings"][k]);
		}
		
	}
*/

function doQuery_back(result)
{
	 jsonData = JSON.parse(result);
	   document.getElementById("content").innerHTML='<object type="text/html" data=jsonData ></object>';
	  // Create the table element
	  console.log(result);
         let table = document.createElement("table");
         let div = document.createElement("div");
       //  content.innerHTML = "WELCOME TO THE RESULT "+result;
         // Get the keys (column names) of the first object in the JSON data
         let cols = Object.keys(jsonData["results"]);
         let bookingRef = uuidv4();
     
     	//     document.write(obj["results"]["bindings"][0]["cottageID"]["value"] + "<br>");
        // content.innerHTML += "The following matches found for your query... <br /> "+ printValues(jsonData);
          content.innerHTML += " <h2> Booking Reference:  "+ bookingRef +"</h2><br/>"+ "<br/><h2>The following matches found for your query... </h2><br /> "+ result;
         /*
         // Create the header element
         let thead = document.createElement("thead");
         let tr = document.createElement("tr");
         console.log("THIS IS FROM COLS ---- "+cols[0]);
         let val = cols[0];
         console.log("What is the value of "+val);
        */
        /* 
         // Loop through the column names and create header cells
         cols.forEach((item) => {
            let th = document.createElement("th");
            th.innerText = item; // Set the column name as the text of the header cell
            tr.appendChild(th); // Append the header cell to the header row
         });
         thead.appendChild(tr); // Append the header row to the header
         table.append(tr) // Append the header to the table
         
         // Loop through the JSON data and create table rows
         jsonData.forEach((item) => {
            let tr = document.createElement("tr");
            
            // Get the values of the current object in the JSON data
            let vals = Object.values(item);
            
            // Loop through the values and create table cells
            vals.forEach((elem) => {
               let td = document.createElement("td");
               td.innerText = elem; // Set the value as the text of the table cell
               tr.appendChild(td); // Append the table cell to the table row
            });
            table.appendChild(tr); // Append the table row to the table
         });
         */
	//	table.append(tr);
         //content.appendChild(table);
	//alert('result:'+jsonData);
}






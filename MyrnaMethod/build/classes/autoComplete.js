/**
 * 
 */

$(document).ready(function() {
     $(function() {
         $("#drug1").autocomplete({  
             source : function(request, response) {
               $.ajax({
                    url : "AutoComplete",
                    type : "GET",
                    data : {
                           term : request.term
                    },
                    dataType : "json",
                    success : function(data) {
                          response(data);
                    }
             });
          }
      });
   });
});
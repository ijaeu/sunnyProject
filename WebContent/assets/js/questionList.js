

$(document).ready(function() {
  // listen for changes in the select element
  $('#questionStatusSelect').on('change', function() {
    // get the selected option value
    var questionStatus = $(this).val();
    var gosuNumber = $('#gosuNumber').val();
    
    // send the AJAX request
    $.ajax({
      url: '/question/questionListChange.qs',
      method: 'GET',
      data: {
        questionStatus: questionStatus,
        gosuNumber: gosuNumber
      },
      success: function(response) {
        // update the HTML with the new data
        $('#questionList').html(response);
      },
      error: function(xhr) {
        // handle errors
      }
    });
  });
});

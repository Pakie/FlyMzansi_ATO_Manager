/* ------------------------------------------------------------------------------
 *
 *  # Custom JS code
 *
 *  Place here all your custom js. Make sure it's loaded after app.js
 *
 * ---------------------------------------------------------------------------- */
/* ------------------------------------------------------------------------------
 *
 *  # Buttons extension for Datatables. Init examples
 *
 *  Demo JS code for datatable_extension_buttons_init.html page
 *
 * ---------------------------------------------------------------------------- */


// Setup module
// ------------------------------

var DatatableButtons = function() {


    //
    // Setup module components
    //

    // Basic Datatable examples
    var _componentDatatableButtons = function() {
        if (!$().DataTable) {
            console.warn('Warning - datatables.min.js is not loaded.');
            return;
        }

        // Setting datatable defaults
        $.extend( $.fn.dataTable.defaults, {
            autoWidth: false,
            dom: '<"datatable-header"fBl><"datatable-scroll-wrap"t><"datatable-footer"ip>',
            language: {
                search: '<span>Filter:</span> _INPUT_',
                searchPlaceholder: 'Type to filter...',
                lengthMenu: '<span>Show:</span> _MENU_',
                paginate: { 'first': 'First', 'last': 'Last', 'next': $('html').attr('dir') == 'rtl' ? '&larr;' : '&rarr;', 'previous': $('html').attr('dir') == 'rtl' ? '&rarr;' : '&larr;' }
            }
        });


        // Basic initialization
        $('.datatable-button-init-basic').DataTable({
            buttons: {
                dom: {
                    button: {
                        className: 'btn btn-light'
                    }
                },
                buttons: [
                    {extend: 'copy'},
                    {extend: 'csv'},
                    {extend: 'excel'},
                    {extend: 'pdf'},
                    {extend: 'print'}
                ]
            }
        });

        // Custom button
        $('.datatable-button-init-add_room').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "rooms/add-room"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_room_category').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "rooms/room-categories/add-room-category"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_department').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "departments/add-department"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_course').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "courses/add-course"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_subject').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "subjects/add-subject"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_instructor').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "employees/instructors/add-instructor"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_student').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "students/add-student"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_event').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "events/add-event"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_aircraft').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "aircrafts/add-aircraft"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_aircraft_type').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "aircrafts/aircraft-types/add-aircraft-type"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_aircraft_maintenance').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "aircraft-maintenances/add-aircraft-maintenance"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_exam').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "exams/add-exam"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_simulator').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "simulators/add-simulator"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_sim_session').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "add-sim-session"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_sponsor').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "sponsors/add-sponsor"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_pilot').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "pilots/add-pilot"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_employee').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "employees/add-employee"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_customer').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "customers/add-customer"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_flight').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "flights/add-flight"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_rating').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                       window.location.href = "ratings/add-rating"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_ground_school').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "ground-schools/add-ground-school"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_employment_position').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "employment-positions/add-employment-position"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_employment_type').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "employment-types/add-employment-type"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_mechanic').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "mechanics/add-mechanic"
                    }
                }
            ]
        });

        $('.datatable-button-init-add_status').DataTable({
            buttons: [
                {
                    text: 'Add New',
                    className: 'btn bg-teal-400',
                    action: function(e, dt, node, config) {
                        window.location.href = "statuses/add-status"
                    }
                }
            ]
        });

        // Buttons collection
        $('.datatable-button-init-collection').DataTable({
            buttons: [
                {
                    extend: 'collection',
                    text: '<i class="icon-three-bars"></i>',
                    className: 'btn bg-blue btn-icon dropdown-toggle',
                    buttons: [
                        {
                            text: 'Toggle first name',
                            action: function ( e, dt, node, config ) {
                                dt.column( 0 ).visible( ! dt.column( 0 ).visible() );
                            }
                        },
                        {
                            text: 'Toggle status',
                            action: function ( e, dt, node, config ) {
                                dt.column( -2 ).visible( ! dt.column( -2 ).visible() );
                            }
                        }
                    ]
                }
            ]
        });


        // Page length
        $('.datatable-button-init-length').DataTable({
            dom: '<"datatable-header"fB><"datatable-scroll-wrap"t><"datatable-footer"ip>',
            lengthMenu: [
                [ 10, 25, 50, -1 ],
                [ '10 rows', '25 rows', '50 rows', 'Show all' ]
            ],
            buttons: [
                {
                    extend: 'pageLength',
                    className: 'btn bg-slate-600'
                }
            ]
        });
    };

    // Select2 for length menu styling
    var _componentSelect2 = function() {
        if (!$().select2) {
            console.warn('Warning - select2.min.js is not loaded.');
            return;
        }

        // Initialize
        $('.dataTables_length select').select2({
            minimumResultsForSearch: Infinity,
            dropdownAutoWidth: true,
            width: 'auto'
        });
    };


    //
    // Return objects assigned to module
    //

    return {
        init: function() {
            _componentDatatableButtons();
            _componentSelect2();
        }
    }
}();


// Initialize module
// ------------------------------

document.addEventListener('DOMContentLoaded', function() {
    DatatableButtons.init();
});


// Alert combination
$('#sweet_combine').on('click', function() {
    swalInit({
        title: 'Are you sure you want to delete it?',
        text: "You won't be able to revert this!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel!',
        confirmButtonClass: 'btn btn-success',
        cancelButtonClass: 'btn btn-danger',
        buttonsStyling: false
    }).then(function(result) {
        if(result.value) {
            swalInit(
                'Deleted!',
                'Your file has been deleted.',
                'success'
            );
        }
        else if(result.dismiss === swal.DismissReason.cancel) {
            swalInit(
                'Cancelled',
                'Your imaginary file is safe :)',
                'error'
            );
        }
    });
});
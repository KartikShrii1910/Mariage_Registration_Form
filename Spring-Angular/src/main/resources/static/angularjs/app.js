var app = angular.module('MarriageRegistrationApp', [])

app.controller('RegistrationController', function($scope, $window, $http) {
	$scope.registration = {};
	$scope.isFormSubmitted = false;
	$scope.isConfirmationPopupVisible = false;
	$scope.imagePreview = null;

	$scope.finalSubmitForm = function() {
		$http.post('/persondetails/new', $scope.registration)
			.then(function(response) {
				console.log('Server response:', response.data);
			})
			.catch(function(error) {
				console.error('Error:', error);
			});

		Swal.fire({
			title: 'Registration Successful!',
			text: 'Thank you for registering!',
			icon: 'success',
		});




		$scope.isConfirmationPopupVisible = true;
		$scope.resetForm();
	};

	$scope.resetForm = function() {
		$scope.registration = {};
		$scope.isFormSubmitted = false;
		$scope.imagePreview = null; // Clear image preview
	};

	$scope.submitForm = function() {
		if ($scope.registration.name && $scope.registration.dateOfBirth && $scope.registration.email && $scope.registration.maritalStatus && $scope.registration.area && $scope.registration.mobileNumber) {
			Swal.fire({
				title: 'Are you sure?',
				text: 'Do you want to submit the form?',
				icon: 'question',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: 'Yes, submit it!'
			})
		}
		else {
			Swal.fire({
				title: 'please fill importatnt information',
				icon: 'warning',
				confirmButtonText: 'OK'
			});

		}
		$scope.isFormSubmitted = true;
	};

	$scope.showImagePreview = function(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$scope.$apply(function() {
					$scope.imagePreview = e.target.result;
				});
			};
			reader.readAsDataURL(input.files[0]);
		}
	};

	$scope.isFormValid = function() {
		return $scope.registration.name && $scope.registration.dateOfBirth && $scope.registration.email && $scope.registration.maritalStatus && $scope.registration.area && $scope.registration.mobileNumber;
	};

	$scope.calculateAge = function() {
		var dob = new Date($scope.registration.dateOfBirth);
		var today = new Date();

		// Check if the birth year is before 2000

		var age = today.getFullYear() - dob.getFullYear();
		var monthDiff = today.getMonth() - dob.getMonth();

		if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
			age--;
		}
		$scope.registration.age = age;

	}

	$scope.removeImage = function() {
		$scope.registration.profilePhoto = null;
		$scope.imagePreview = null;
	};

});

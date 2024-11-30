document.addEventListener('DOMContentLoaded', () => {
    const signinForm = document.getElementById('signin-form');
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');
    const emailError = document.getElementById('email-error');
    const passwordError = document.getElementById('password-error');
    const serverError = document.getElementById('server-error');

    signinForm.addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent the default form submission

        // Clear error messages
        emailError.textContent = '';
        passwordError.textContent = '';
        serverError.textContent = '';

        const email = emailInput.value.trim();
        const password = passwordInput.value.trim();

        // Client-side validation
        if (!email) {
            emailError.textContent = 'Email is required.';
            return;
        }
        if (!password) {
            passwordError.textContent = 'Password is required.';
            return;
        }

        try {
            // Send POST request to backend
            const response = await fetch('/api/sign-in', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            });

            const data = await response.json();

            // Handle the response
            if (data.success) {
                // Redirect to home page on success
                window.location.href = '/';
            } else {
                // Display server-side error message
                serverError.textContent = data.message || 'Invalid login credentials.';
            }
        } catch (error) {
            console.error('Error:', error);
            serverError.textContent = 'An unexpected error occurred. Please try again.';
        }
    });
});

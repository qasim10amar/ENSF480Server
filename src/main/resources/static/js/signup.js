document.addEventListener('DOMContentLoaded', () => {
    const signupForm = document.getElementById('signup-form');
    const passwordInput = document.getElementById('password');
    const repeatPasswordInput = document.getElementById('repeat-password');
    const usernameInput = document.getElementById('username');

    const passwordError = document.getElementById('password-error');
    const repeatPasswordError = document.getElementById('repeat-password-error');
    const usernameError = document.getElementById('username-error');

    signupForm.addEventListener('submit', (event) => {
        let valid = true;

        // Clear previous error messages
        passwordError.textContent = '';
        repeatPasswordError.textContent = '';
        usernameError.textContent = '';

        // Password length check
        if (passwordInput.value.length < 8) {
            passwordError.textContent = 'Password must be at least 8 characters long.';
            valid = false;
        }

        // Password match check
        if (passwordInput.value !== repeatPasswordInput.value) {
            repeatPasswordError.textContent = 'Passwords do not match.';
            valid = false;
        }

        if (!valid) {
            event.preventDefault(); // Prevent form submission
            return;
        }

        // Proceed with form submission (handled by the server)
    });
});

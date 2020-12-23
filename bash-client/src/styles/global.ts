import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    outline: 0;
    box-sizing: border-box;
  }

  html, body, #root {
    height: 100%;
  }

  body {
    font-size: 16px;
    font-family: 'Open Sans', sans-serif;
    background-color: #fff;
    color: #333;

    -webkit-font-smoothing: antialiased !important;

    a {
      color: #333;
    }
  }
  button {
    font-size: 16px;
    font-family: 'Open Sans', sans-serif;
    -webkit-font-smoothing: antialiased !important;
  }

  :root {
    --color-info-user: #d5d5d5;
    --color-text-bash: #d4d4d4;
    --font-size-bash: 18px;
    --space-between-info: 8px;
  }
`;
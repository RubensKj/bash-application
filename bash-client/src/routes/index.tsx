import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

// Pages
import Bash from '../pages/Bash';

const Routes: React.FC = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path='/' component={Bash} />
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
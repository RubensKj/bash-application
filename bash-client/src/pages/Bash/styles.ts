import styled from 'styled-components';

export const Container = styled.div`
  color: var(--color-text-bash) !important;
  font-size: var(--font-size-bash) !important;

  width: 100%;
  height: 100%;
  background-color: #0d1117;

  padding: 15px;

  padding-top: 15px;

  overflow-y: auto;
`;

export const InputArea = styled.div`
  width: 100%;

  display: flex;
  justify-content: flex-start;

  form {
    display: flex;
    justify-content: flex-start;
    align-items: center;

    width: 100%;
  }
`;

export const Lines = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;

  width: 100%;
`;
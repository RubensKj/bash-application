import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  justify-content: flex-start;
  align-items: flex-start;

  overflow: hidden;

  margin-left: var(--space-between-info);
  width: 100%;

  font-size: var(--font-size-bash) !important;
`;

export const Input = styled.input`
  width: 100%;
  height: 100%;

  background: transparent;
  border: none;

  color: var(--color-text-bash) !important;
  font-size: var(--font-size-bash) !important;
`;

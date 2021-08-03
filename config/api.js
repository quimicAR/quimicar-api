module.exports = ({ env }) => ({
  responses: {
    privateAttributes: ["_v", "id", "created_at"],
  },
  rest: {
    defaultLimit: 119,
    maxLimit: 119,
  },
});

import { LinkRequest, LinkResponse } from "../types/LinkTypes";
import { api } from "./api";

export const linkService = {
  shortenerLink: async (urlInput: string): Promise<LinkResponse> => {
    
    const body: LinkRequest = {
      urlOriginal: urlInput,
    };

    const response = await api.post<LinkResponse>("", body);

    return response.data;
  },

  findLink: async (shortCode: string): Promise<void> => {
    await api.get(`/${shortCode}`);
  },
};

import { useState } from "react";
import { linkService } from "../services/LinkService";
import { LinkResponse } from "../types/LinkTypes";

export default function ShortenerForm() {
  const [urlInput, setUrlInput] = useState("");
  const [linkReady, setLinkReady] = useState<LinkResponse | null>(null);
  const [erro, setErro] = useState("");

  const handleEncurtar = async () => {
    if (!urlInput) return;

    try {
      setErro("");

      const result = await linkService.shortenerLink(urlInput);

      setLinkReady(result);
    } catch (error) {
      console.error(error);
      setErro("Erro ao encurtar. Verifique a URL.");
    }
  };

  return (
    <div className="flex flex-col items-center w-full px-4">
      <form className="flex flex-col items-center gap-4 mt-5 w-full">
        <input
          className="p-1 w-full font-semibold text-base text-center rounded-md border-2 border-[#69552e] text-[#513300] placeholder-[#513300]/50"
          onChange={(e) => setUrlInput(e.target.value)}
          value={urlInput}
          type="url"
          placeholder="Cole seu Link aqui..."
        />

        <button
          type="button"
          onClick={handleEncurtar}
          className="p-1 w-full cursor-pointer text-base text-white font-semibold text-center rounded-md bg-[#513300] hover:bg-[#7a4d00] transition-colors"
        >
          ENCURTAR
        </button>
      </form>

      {erro && <p className="text-red-600 mt-2 font-bold">{erro}</p>}

      {linkReady && (
        <div className="mt-8 p-2 bg-white rounded-lg text-center w-full border-2 border-[#513300]">
          <p className="text-sm text-[#513300] font-bold">Link Encurtado:</p>
          <a
            href={linkReady.urlShortened}
            target="_blank"
            className="text-xl font-bold text-[#513300] underline break-all hover:text-blue-600"
          >
            {linkReady.urlShortened}
          </a>
        </div>
      )}
    </div>
  );
}
